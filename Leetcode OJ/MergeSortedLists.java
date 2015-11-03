
class MergeSortedLists{
	public static void main(String args[]){
		int arr1[] = {1,5,7,8};
		int arr2[] = {2,3,10,15};
		LinkedList ll1 = new LinkedList();
		LinkedList ll2 = new LinkedList();
		ll1.createListFromArray(arr1);
		ll2.createListFromArray(arr2);
		printFromNode(mergeHelper(ll1.head, ll2.head));
	}


	public static LinkedListNode merge(LinkedListNode[] arr){
		LinkedListNode prev = arr[0];
		for(int i=1;i<arr.length;i++){
			prev = mergeHelper(prev, arr[i]);
		}
		return prev;
	}

	public static LinkedListNode mergeHelper(LinkedListNode l1, LinkedListNode l2){
		if(l2==null || l1==null)
			return l2==null ? l1 : l2;
		LinkedListNode head=null;
		LinkedListNode prev = null;
		while(l1!=null && l2!=null){
			LinkedListNode newnode = null;
			if(l1.val < l2.val){
				newnode = new LinkedListNode(l1.val);
				l1 = l1.next;
			}
			else{
				newnode = new LinkedListNode(l2.val);
				l2 = l2.next;
			}
			if(prev!=null){
				prev.next=newnode;
			}
			if(prev==null)
				head = newnode;
			prev = newnode;						
		}

		while(l1!=null){
			LinkedListNode newnode = new LinkedListNode(l1.val);
			l1 = l1.next;
			prev.next = newnode;
			prev= newnode;
		}

		while(l2!=null){
			LinkedListNode newnode = new LinkedListNode(l2.val);
			l2 = l2.next;
			prev.next = newnode;
			prev= newnode;
		}

		return head;
	}

	public static void printFromNode(LinkedListNode node){
		while(node!=null){
			System.out.print(node.val+" ");
			node = node.next;
		}
		System.out.println();
	}
}