import java.io.*;
import java.util.*;

class ReverseStackRecursion{
	public static void main(String args[])throws IOException{
		Stack s = new Stack();
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);

		Stack rev = reverse(s);
		printStack(rev);

	}

	public static void printStack(Stack s){
		while(!s.isEmpty())
			System.out.println((Integer)s.pop());
	}


	public static Stack reverse(Stack s){
		int top = (Integer)s.pop();
		if(s.isEmpty()){
			s.push(top);
			return s;
		}
		Stack substack = reverse(s);
		s = insertToBottom(top, substack);
		return s;
	}

	public static Stack insertToBottom(int elem, Stack s){
		int top = (Integer)s.pop();
		if(s.isEmpty())
			s.push(elem);
		else
			insertToBottom(elem, s);
		s.push(top);
		return s;
	}
}