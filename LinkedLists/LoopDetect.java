class Node
{
    int val;
    Node next;
    Node(int val)
    {
        this.val=val;
        next=null;
    }
}

class LinkedList
{
    Node head;
    LinkedList()
    {
        head=null;
        
    }
    Node insertLast(int val)
    {
        if(head==null)
        {
            head = new Node(val);
            return head;
        }
        Node temp = head;
        while(temp.next!=null)
        {
            temp = temp.next;
        }
        temp.next = new Node(val);
        return temp.next;              
    }
    
    void insertLast(int val, boolean loop)
    {
        Node temp = insertLast(val);
        Node searcher = head;
        while(searcher.val!=val)
        {
            searcher=searcher.next;
        }
        temp.next = searcher;
    }


    void printList()
    {
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.val+" ");
            temp = temp.next;
        }



    }

    void printFromNode(Node n){
    	while(n!=null){
    		System.out.println(n.val);
    		n = n.next;
    	}
    }

}


class LoopDetect
{
    public static void main(String args[])
    {
        
        LinkedList ll = new LinkedList();
        ll.insertLast(1);
        ll.insertLast(2);
        ll.insertLast(3);
        ll.insertLast(4);
        ll.insertLast(5);
        ll.insertLast(6);
        ll.insertLast(7);
        ll.insertLast(2,true);
        
        ll.printList();
        System.out.println();

        System.out.println("start of loop="+detectLoop(ll).val);
    }
    
    
    static Node detectLoop(LinkedList ll)
    {
        Node slowRunner = ll.head;
        Node fastRunner = ll.head;
        

        while(true)
        {
            slowRunner=slowRunner.next;
            fastRunner=fastRunner.next.next;
            if(slowRunner==fastRunner && slowRunner!=ll.head)
            {
                break;
            }
        }
        System.out.println("collision at="+slowRunner.val);
        slowRunner=ll.head;
        
        while(slowRunner!=fastRunner)
        {
            slowRunner=slowRunner.next; 
            fastRunner=fastRunner.next;
        }
        
        return slowRunner;
    }

}