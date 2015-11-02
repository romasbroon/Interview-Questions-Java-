import java.util.Stack;
class ContainerMaxWater{
	public static void main(String args[]){
		int x[] = {1,2,1000,1,2};
		System.out.println("MAX VAL: "+maxAreaRecursive(x, 0, x.length-1));
	}

	public static int maxArea(int x[]){
		int n = x.length;
		int left=0, right=0, max=0;
		int cur_min = 0, size=1;
		Stack<Integer> stack = new Stack<Integer>();
		for(int i=0;i<n;i++){
			if(stack.empty()){
				stack.push(i);
				cur_min = x[i];
				left=i;
				size=1;
			}
			else if(x[i] <= x[stack.peek()]){
				stack.push(i);
				size++;
				cur_min = x[i];
				if(max < cur_min*(i-left))
					max = cur_min*(i-left);
			}
			else{
				int pop_count=0;
				while(!stack.empty() && x[stack.peek()] < x[i]){
					stack.pop();
					pop_count++;
					size--;
				}
				if(pop_count*cur_min > max)
					max = pop_count*cur_min;
				if(stack.empty()){
					size=1;
					left=i;
				}
				else					
					size++;	
				
				stack.push(i);
				cur_min = x[i];
				if(max < cur_min*(i-left))
					max = cur_min*(i-left);
			}
		}
		//System.out.println("width:"+(n-left-1)+" cur_min:"+cur_min);

		return Math.max(max, cur_min*(n-1-left));
	}


	public static int maxAreaRecursive(int x[], int start, int end){
		printArr(x, start, end);
		int size = end-start+1;
		if(size<=1)
			return 0;
		if(size==2)
			return Math.min(x[start], x[end]);

		int minIndex = minIndex(x, start, end);
		System.out.println("minIndex: "+minIndex);
		int maxArea = x[minIndex]*(end-start);
		int leftArea = maxAreaRecursive(x, start, minIndex-1);
		int rightArea = maxAreaRecursive(x, minIndex+1, end);
		maxArea = Math.max(maxArea, leftArea);
		maxArea = Math.max(maxArea, rightArea);
		return maxArea;
	}


	public static int minIndex(int x[], int start, int end){
		int minIndex = start;
		for(int i=start+1;i<=end; i++){
			if(x[i] < x[minIndex])
				minIndex=i;
		}
		return minIndex;
	}

	public static void print(String message){System.out.println(message);}
	public static void printArr(int x[], int start, int end){
		for(int i=start;i<=end;i++)
			System.out.print(x[i]+" ");
		System.out.println();
	}

}