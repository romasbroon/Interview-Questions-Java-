class LinkedListNode{
	int val;
	LinkedListNode next;
	LinkedListNode(int val){
		this.val = val;
	}
}
class LinkedList{
	public static void main(String[] args) {
		
		LinkedListNode head = new LinkedListNode(1);
		LinkedListNode t1 = new LinkedListNode(2);
		LinkedListNode t2 = new LinkedListNode(4);
		head.next=t1;
		t1.next=t2;
		getCount(head);
		print(head);
	}	

	public static void print(LinkedListNode head){
		while(head!=null){
			System.out.print(head.val+" ");
			head = head.next;
		}
		System.out.println();
	}
	public static int getCount(LinkedListNode head){
		int count=0;
		while(head!=null){
			count++;
			head = head.next;
		}
		return count;
	}
}