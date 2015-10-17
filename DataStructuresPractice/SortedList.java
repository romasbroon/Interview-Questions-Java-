public class SortedList
{
  //METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
  public static CNode insertSortedList(CNode start, int n)
  {
    // INSERT YOUR CODE HERE
   //If smaller than first node, insertion at beginning
   if(n < start.value){
        CNode newnode = createHelper(n);
        CNode temp = start;
        CNode nextnode = temp.next;
        
        while(nextnode!=start){
            temp = nextnode;
            nextnode = temp.next;
        }
        newnode.next=start;
        start = newnode;
        temp.next = newnode;
        return newnode;
   }
   else{
        CNode newnode = createHelper(n); 
        CNode nextnode = start.next;
        CNode curr = start;
        while(nextnode != start){
            if(nextnode.value > n && curr.value <= n){
                
                newnode.next = curr.next;
                curr.next = newnode; 
                return newnode;
            }
            curr = nextnode;
            nextnode = curr.next;
        }
    
    //If greater than all nodes
        if(curr!=start && nextnode==start){
            curr.next = newnode;
            newnode.next= start;
        }
        return newnode;
   }//else
   
    
  }
  
  //Helper to create new node and return it.
  public static CNode createHelper(int val){
      CNode node = new CNode();
      node.value=val;
      node.next=null;
      return node;
  }
  // METHOD SIGNATURE ENDS
}

class CNode{
  int value;
  CNode next;
}