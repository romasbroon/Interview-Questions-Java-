class ReverseListGroup{
	public static void main(String args[]){
		LinkedList list = new LinkedList();
		int k = Integer.parseInt(args[0]);
		int x[] = {1,2,3,4,5,6};
		list.createListFromArray(x);
		System.out.println("Original List: ");
		list.print(list.head);
		System.out.println("Reversed List: ");
		list.print(reverseGroup(list.head, k));

	}

	//Reverses k nodes starting at head, returns new head
	public static LinkedListNode reverseGroup(LinkedListNode head, int k){
		if(head==null || !nodeCount(head, k))
			return head;
		LinkedListNode curr = head;
		LinkedListNode nx = curr.next;
		for(int i=1; i<k; i++){
			LinkedListNode temp = nx.next;
			nx.next = curr;
			curr = nx;
			nx = temp;
		}
		head.next = reverseGroup(nx, k);
		return curr;  

	}

	//Returns true if ll contains atleast k nodes
	public static boolean nodeCount(LinkedListNode head, int k){
		int count=0;
		while(head!=null && count<k){
			head = head.next;
			count++;
		}
		if(count==k)
			return true;
		return false;
	}
}