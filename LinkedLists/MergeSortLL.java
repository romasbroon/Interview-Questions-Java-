class MergeSortLL{
	public static void main(String args[]){
		LinkedList ll = new LinkedList();
		ll.insertLast(4);
		ll.insertLast(3);
		ll.insertLast(2);
		ll.insertLast(1);

		ll = mergeSort(ll.head, 4);
		ll.printList();	
		System.out.println();
	}


	//Sorts a Linked list using merge sort
	public static LinkedList mergeSort(Node head, int n){
		//System.out.println("Function call: "+head.val+" n="+n);		
		if(n==1)
		{
			LinkedList newlist = new LinkedList();
			newlist.insertLast(head.val);
			return newlist;			
		}	

		Node mid= middle(head); //end of first ll
		Node temp = mid.next;
		mid.next=null;

		int rn = n/2;
		int ln = n%2==1 ? n/2+1 : n/2;
		LinkedList left_part = mergeSort(head, ln);
		LinkedList right_part = mergeSort(temp, rn);
		return merge(left_part, right_part);
	}


	public static Node middle(Node head){
		Node slow = head;
		Node fast = head;
		while(fast.next!=null && fast.next.next!=null){
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow;
	}

	//Merges two linked lists
	public static LinkedList merge(LinkedList ll1, LinkedList ll2){
		
		Node n1= ll1.head;
		Node n2 = ll2.head;

		LinkedList res = new LinkedList();
		while(n1!=null && n2!=null){
			if(n1.val  <= n2.val){
				res.insertLast(n1.val);
				n1 = n1.next;
			}
			else{
				res.insertLast(n2.val);
				n2 = n2.next;
			}

		}

		if(n1!=null){
			while(n1!=null){
				res.insertLast(n1.val);
				n1 = n1.next;
			}	
		}
		
		if(n2!=null){
			while(n2!=null){
				res.insertLast(n2.val);
				n2 = n2.next;
			}	
		}
		return res;
	}//merge()
}


