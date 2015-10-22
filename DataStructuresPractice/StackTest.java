class StackTest{
	public static void main(String args[]){
		MinStack stack = new MinStack();
		stack.push(3);
		stack.push(2);
		stack.push(5);
		stack.push(1);
		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();
		System.out.println(stack.getMin());
	}
}