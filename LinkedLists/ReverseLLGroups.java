class ReverseLLGroups{
	static int group_size = 2;
static LinkedList ll = new LinkedList();
	public static void main(String args[]){
		//LinkedList ll = new LinkedList();
		ll.insertLast(1);
		ll.insertLast(2);
		ll.insertLast(3);
		ll.insertLast(4);
		ll.insertLast(5);
		ll.insertLast(6);
		//ll.printFromNode(ll.head);
		Node ll_head = rev(ll.head, group_size);
		ll.printFromNode(ll_head);

	}//main

	public static Node rev(Node n, int k){

		//System.out.println("n="+n.val+" and k="+k);
		Node nextnode = n.next;
		if(k==1){
			n.next=null;
			return n;
		}
		if(k==group_size){
			//Find node that is at group_size distance
			Node t2=n;
			for(int i=0;i<k && t2!=null; i++){
				t2 = t2.next;
			}
			if(t2!=null){
				Node t3 = rev(t2, group_size);
				//ll.printFromNode(t3);
				n.next = t3;	
			}
			else
				n.next=null;			
		}
		Node t1 = rev(nextnode, k-1);
		
		Node ret = t1;
		while(t1.next!=null)
			t1=t1.next;
		//System.out.println(t1.val);
		t1.next=n;
		if(k!=group_size)
			n.next = null;
		return ret;

	}//rev()

}//class

//1-2-3-4-5-6