import java.util.TreeMap;
import java.util.Map;

class MergeSortedLists{
	public static void main(String args[]){
		int arr1[] = {4,5};
		int arr2[] = {2,3};

		LinkedList ll1 = new LinkedList();
		LinkedList ll2 = new LinkedList();
		ll1.createListFromArray(arr1);
		ll2.createListFromArray(arr2);
		//printFromNode(ll1.head);
		LinkedListNode[] list = new LinkedListNode[2];
		list[0] = ll1.head;
		list[1] = ll2.head;
		printFromNode(mergeKListsAliter(list));
	}

	public static LinkedListNode mergeKLists(LinkedListNode[] lists) {
        LinkedListNode newhead = null;
        LinkedListNode prev = null;
        LinkedListNode min = getMin(lists);
        int count=0;
        while(min != null){
        	count++;
            if(newhead == null){
                newhead = min;
                prev = min;
            }
            else{
                prev.next = min;
                prev = min;
            }
            min = getMin(lists);
        }
        return newhead;
    }

	public static LinkedListNode getMin(LinkedListNode[] lists){
        LinkedListNode minNode = null;
        int index = -1;
        for(int i=0;i<lists.length;i++){
            LinkedListNode node = lists[i];
            if(minNode == null && node != null){
                minNode = node;
                index=i;
            }
            else{
                if(node!=null)
                    if(minNode.val > node.val){
                    	index = i;
                        minNode = node;
                    }
            }
        }
        if(minNode!=null){
        	//System.out.println("Min val: "+minNode.val);
        	lists[index] = minNode.next;
        }
        return minNode;
    }    

    public static void printFromNode(LinkedListNode node){
    	while(node!=null){	
    		System.out.print(node.val+" ");
    		node = node.next;
    	}
    	System.out.println();
    }


    public static LinkedListNode mergeKListsAliter(LinkedListNode[] lists){
    	TreeMap<Integer, Integer> vals = new TreeMap<Integer, Integer>();
    	for(LinkedListNode headnode  : lists){
    		addToMap(vals, headnode);
    	}

    	LinkedListNode newhead = null;
    	LinkedListNode prev = null;

    	for(Map.Entry<Integer,Integer> entry : vals.entrySet()) {
			int key = entry.getKey();
			int value = entry.getValue();
			for(int i=0;i<value;i++){
				if(newhead == null){
					newhead = new LinkedListNode(key);
					prev  = newhead;
				}
				else{
					LinkedListNode node = new LinkedListNode(key);
					prev.next = node;
					prev = node;
				}
			}
		}
		return newhead;	

    }

    public static void addToMap(TreeMap<Integer, Integer> vals, LinkedListNode head){
    	while(head != null){
    		int key = head.val;
    		int count=0;
    		if(vals.get(key)!=null){
    			count = (Integer)vals.get(key);
    		}
    		vals.put(key, count+1);
    		head = head.next;
    	}
    }

}