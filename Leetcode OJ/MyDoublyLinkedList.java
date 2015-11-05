class DLL{
	CacheNode head;
	CacheNode tail;

	public void addFirst(CacheNode obj){
		if(head==null){			
			head = obj;
			tail = obj;
		}
		else{
			head.next = obj;
			obj.prev = head;
			head = obj;
		}
	}

	public void addLast(CacheNode obj){
		if(head==null){			
			head = obj;
			tail = obj;
		}
		else{
			obj.next = tail;
			tail.prev = obj;
			tail = obj;
		}
	}

	public CacheNode removeLast(){
		if(head==null)
			return null;

		if(head==tail){
			CacheNode ret = head;
			head = null;
			tail=null;
			return ret;
		}
		CacheNode ret = tail;
		CacheNode next_tail = tail.next;
		next_tail.prev = null;
		tail.next=null;
		tail = next_tail;
		return ret;
	}

	public void remove(CacheNode obj){
		if(obj == head){
			if(obj==tail){
				head=null;
				tail=null;
			}
			else{
				head = head.prev;
				obj.prev=null;
			}
		}
		else if(obj==tail){
			tail = tail.next;
			obj.next=null;
		}
		else{
			obj.prev.next = obj.next;
			obj.next.prev = obj.prev;
		}
	}

	public void printDLL(){
		CacheNode temp = head;
		while(temp!=null)
		{
			System.out.print(temp.page_key+" ");
			temp=temp.prev;
		}
		System.out.println();
	}

}
class MyDoublyLinkedList{
	public static void main(String args[]){
		DLL ll = new DLL();
		CacheNode n1 = new CacheNode(1,1);
		CacheNode n2 = new CacheNode(2,2);
		CacheNode n3 = new CacheNode(3,3);
		CacheNode n4 = new CacheNode(4,4);

		
		ll.addFirst(n1);
		ll.addLast(n2);
		ll.addLast(n3);
		ll.addLast(n4);

		ll.remove(n3);


		ll.printDLL();

	}
}