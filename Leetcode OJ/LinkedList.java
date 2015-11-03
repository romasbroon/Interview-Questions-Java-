class LinkedListNode{
	int val;
	LinkedListNode next;
	LinkedListNode(int val){
		this.val = val;
	}
}
class LinkedList{
	
	LinkedListNode head = null;

	public void print(LinkedListNode head){
		while(head!=null){
			System.out.print(head.val+" ");
			head = head.next;
		}
		System.out.println();
	}
	public int getCount(LinkedListNode head){
		int count=0;
		while(head!=null){
			count++;
			head = head.next;
		}
		return count;
	}


	public void createListFromArray(int x[]){
		LinkedListNode prev = null;
		for(int i=0;i<x.length;i++){
			if(i==0){
				head= new LinkedListNode(x[i]);
				prev = head;
			}
			else{
				LinkedListNode curr = new LinkedListNode(x[i]);
				prev.next = curr;
				prev=curr;
			}
		}
	}
}