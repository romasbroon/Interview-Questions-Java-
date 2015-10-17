class LinkedListNode{
	int val;
	LinkedListNode next;
	LinkedListNode(int val){
		this.val = val;
		this.next = null;
	}
}

class LinkedList{
	LinkedListNode head;
	public void insert(int val){
		LinkedListNode newnode = new LinkedListNode(val);
		if(head==null){
			head = newnode;
			return;
		}
		LinkedListNode temp = head;
		while(temp.next != null)
			temp = temp.next;
		temp.next = newnode;

	}

	public LinkedListNode search(int val){
		LinkedListNode temp = head;
		while(temp!=null){
			if(temp.val==val)
				return temp;
			temp = temp.next;
		}
		return null;
	}

	public void delete(int val){
		LinkedListNode delete_node = search(val);
		LinkedListNode temp = head;
		if(delete_node==head)
			head = head.next;
		else{
			while(temp.next != delete_node)
				temp = temp.next;
		}
		temp.next = delete_node.next;
		delete_node.next = null;

	}


	public void printList(){
		LinkedListNode temp = head;
		while(temp!=null){
			System.out.print(temp.val+" ");
			temp = temp.next;
		}
		System.out.println();
	}

}

class LinkedListTest{
	public static void main(String args[]){
		LinkedList list = new LinkedList();
		list.insert(1);
		list.insert(2);
		list.insert(3);
		//list.delete(1);
		list.printList();
	}
}