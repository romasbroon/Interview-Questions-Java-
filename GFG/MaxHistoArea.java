import java.util.Stack;
class MaxHistoArea{

	static int h[] = null; 
	static Stack<Integer> s = new Stack<Integer>();
	public static void main(String args[]){
		h = new int[7];
		h[0]=6;h[1]=2;h[2]=5;h[3]=4;h[4]=5;h[5]=1;h[6]=6;
	
		System.out.println("Max area: "+area());



	}//main

	public static int area(){
		int max_area=-1;
		int i=0;
		int n = h.length;
		while(i<n){

			if(s.empty() || h[i]>h[(Integer)s.peek()]){
				s.push(i++);
				//System.out.println("push");
			}
			else{
				//System.out.println("pop");
				
				int top = (Integer)s.pop();
				int area = h[top]*(s.empty() ? i : i-(Integer)s.peek()-1);
				if(area > max_area){
					
					max_area=area;
				}
			}
		}

		//POP all bars
		while(s.empty()){
			//System.out.println("pop");
			int top = (Integer)s.pop();
			int area = h[top]*(s.empty() ? i: i-(Integer)s.peek()-1);
			if(area > max_area){
				max_area=area;
			}
		}
		return max_area;
	}

}