class MergeList{
	public static void main(String args[]){
		LinkedList ll1 = new LinkedList();
		LinkedList ll2 = new LinkedList();
		int x[] = {};
		int y[] = {5};
		
		//int x[] = {-9,-7,-3,-3,-1,2,3};
		//int y[] = {-7,-7,-6,-6,-5,-3,2,4};
		ll1.createListFromArray(x);
		ll2.createListFromArray(y);
		LinkedListNode ans = mergeLists(ll1.head, ll2.head);
		while(ans!=null){
			System.out.print(ans.val+" ");
			ans = ans.next;
		}
		System.out.println();
	}
	


	public static LinkedListNode mergeLists(LinkedListNode l1, LinkedListNode l2){
		if(l1 == null || l2 == null)
			return l1==null ? l2 : l1;

		LinkedListNode temp = l1;
		LinkedListNode other = l2;
		LinkedListNode prev = null;
		LinkedListNode newhead = l1.val<=l2.val ? l1 : l2;
		while(temp != null){
			
			while(temp!=null && other!=null && temp.val <= other.val){
				//System.out.println("temp="+temp.val+"  other="+other.val);
				prev = temp;
				temp = temp.next;
			}
			if(prev != null){
				
				//System.out.println("Switching prev="+prev.val+" with other="+other.val);
				prev.next = other;
				
				
			}
			if(temp!=null){

					LinkedListNode old_temp = temp;	
					temp = other;
					other = old_temp;
				}
		}
		return newhead;
	}
}
