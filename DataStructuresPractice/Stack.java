import java.util.Stack;
class MinStack{

	int size;
    final int capacity = 100000;
    int arr[];
    int global_min = Integer.MAX_VALUE;
    Stack<Integer> min_stack = new Stack<Integer>();
    
    MinStack(){
        size=0;
        arr = new int[capacity];
    }
    
    public void push(int x) {
        if(size==capacity)
            System.out.println("Cannot insert, stack full.");
        else{
            arr[++size-1] = x;
            if(x<=global_min){
                global_min = x;
                min_stack.push(x);
            }
        }    
    }

    public void pop() {
        if(size==0)
            return;
        int current_top = arr[size-1];
        size--;
        if(current_top == global_min){
        	min_stack.pop();
        	if(!min_stack.isEmpty())
            	global_min = min_stack.peek();
            else
            	global_min = Integer.MAX_VALUE;
        }
    }

    public int top() {
        if(size > 0)
            return arr[size-1];
        return -1;    
    }

    public int getMin() {
        return global_min;
    }

}