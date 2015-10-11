class DLLNode{
	int val;
	DLLNode next;
	DLLNode prev;

	DLLNode(int val){
		this.val = val;
		this.next=null;
		this.prev=null;
	}

	DLLNode(int val, DLLNode next, DLLNode prev){
		this.val=val;
		this.next = next;
		this.prev = prev;
	}
}

class DLL{
	DLLNode head;

	void insertEnd(int val){
		DLLNode n = new DLLNode(val);
		if(head==null){
			head = n;
			return;
		}

		DLLNode temp = head;
		while(temp.next!=null){
			temp = temp.next;
		}
		temp.next = n;
		n.prev = temp;
	}

	

}//class DLL


class DLLToBST{
	public static void main(String args[]){

		DLL l = new DLL();
		l.insertEnd(1);
		l.insertEnd(2);
		l.insertEnd(3);
		l.insertEnd(4);
		l.insertEnd(5);
		l.insertEnd(6);

		DLLNode root = createLinear(l.head, 7);
		System.out.println("preOrderTraversal:");
		preOrderTraversal(root);
		System.out.println("\ninOrderTraversal:");
		inOrderTraversal(root);

	}

	public static DLLNode create(DLLNode l){

		//Base case
		if(l==null)
			return null;
		if(l.next==null)
			return l;

		DLLNode mid = middleNode(l);
		mid.prev.next=null;
		mid.prev= create(l);

		if(mid.next!=null)
			mid.next.prev = null;
		mid.next = create(mid.next);

		return mid;

	}

	public static DLLNode middleNode(DLLNode l){
		DLLNode slow = l;
		DLLNode fast = l;
		while(fast!=null && fast.next!=null){
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow;
	}

	static void preOrderTraversal(DLLNode n){
		
		System.out.print(n.val+" ");
		if(n.prev!=null)
			preOrderTraversal(n.prev);
		if(n.next!=null)
			preOrderTraversal(n.next);
	}


	static void inOrderTraversal(DLLNode n){

		if(n.prev!=null)
			inOrderTraversal(n.prev);
		System.out.print(n.val+" ");
		if(n.next!=null)
			inOrderTraversal(n.next);
	}

	//Generates BST in linear time.
	public static DLLNode createLinear(DLLNode n, int t){
		//System.out.println("Function call: n="+n.val+" t="+t);	

		if(t==0 || t==1){
			if(t==1 && n!=null)
				n.prev = null;
			return n;
		}
		
		int ln = t/2;
		int rn = t%2==1 ? t/2 : t/2-1;			

		DLLNode left = createLinear(n, ln);
		
		int lcrc = 0;
		lcrc = ln%2==1 ? ln/2 : ln/2-1;

		DLLNode temp=left;
		for(int i=0;i<lcrc;i++)
			temp = temp.next;

		//System.out.println("temp: "+temp.val);
		DLLNode mid = temp.next;
		temp.next = null;

		DLLNode right = createLinear(mid.next, rn);	
		mid.prev = left;
		mid.next = right;



		return mid;
	}
}