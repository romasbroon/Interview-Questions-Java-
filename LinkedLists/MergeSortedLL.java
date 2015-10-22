class MergeSortedLL{
	public static void main(String args[]){
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(5);
		n1.next = n2;

		ListNode n3 = new ListNode(4);
		ListNode n4 = new ListNode(6);
		n3.next = n4;

		printList(mergeTwoLists(n3 ,n1));
		
	}


	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1== null || l2==null)
            return l1==null ? l2 : l1;
        
        //merge in place
        ListNode merge_node=null;
        ListNode return_node=null;
        if(l1.val < l2.val){
            merge_node = l1;
            return_node = l1;
        }
        else{
            merge_node = l2;
            return_node = l2;
        }
        ListNode other_node = merge_node == l1 ? l2 : l1;
        ListNode merge_prev = null;
        
        while(other_node!=null && merge_node!=null){
            if(other_node.val < merge_node.val){
                ListNode temp = other_node.next;
                other_node.next = merge_node;
                merge_prev.next = other_node;
                other_node = temp;
                merge_prev = merge_prev.next;
            }
            else{
                merge_prev = merge_node;
                merge_node = merge_node.next;
            }
        }
        
        //Append other list to merged list
        if(merge_node == null){
            merge_prev.next = other_node;
        }
        
        return return_node;
    }//mergeTwoLists()


    public static void printList(ListNode n){
    	while(n!=null){
    		System.out.print(n.val+" ");
    		n = n.next;
    	}
    	System.out.println();
    }
	
}

 class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; next = null;}
  }