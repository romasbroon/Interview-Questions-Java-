class DelLeftSmallNodes{
	public static void main(String args[]){
		LinkedList ll = new LinkedList();
        ll.insertLast(10);
        ll.insertLast(9);
        ll.insertLast(8);
        ll.insertLast(7);
        ll.insertLast(6);
        Node newhead = del(ll.head);
        ll.head = newhead;

        ll.printList();	
	}

	public static Node del(Node n){
		//Base case
		if(n.next==null)
			return n;

		Node nextlarge = del(n.next);
		if(nextlarge.val > n.val){
			n.next = null;
			return nextlarge;
		}
		else{
			n.next = nextlarge;
			return n;
		}
	}
}