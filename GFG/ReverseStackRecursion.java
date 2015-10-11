import java.util.Stack;
import java.util.ArrayList;

class ReverseStackRecursion{

	static Stack<Integer> stack = new Stack();

	public static void main(String args[]){
		
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
	
		ArrayList<Integer> arr  = new ArrayList();
		reverse(stack, arr);
		
		for(int i : arr)
			stack.push(i);
		
		//Print stack contents:
		while(!stack.empty()){
			System.out.println((Integer)stack.pop());
		}
	}

	public static void reverse(Stack<Integer> stack, ArrayList<Integer> arr){
			
		int x = (Integer)stack.pop();
		arr.add(x);
		
		if(!stack.empty()){
			reverse(stack, arr);
		}
		
	}
	
}