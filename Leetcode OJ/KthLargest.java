class KthLargest{
	public static void main(String args[]){
		int x[] = {3,1,2,4,5,6};
		int k=Integer.parseInt(args[0]);
		System.out.println(findKthLargest(x,k));
	}

	public static int findKthLargest(int x[], int k){
		int n = x.length;
		//Maintain a min heap of k elements in the array x from x[0..k-1] (No extra space)
		for(int i=0;i<n;i++){
			if(i<k)
				heapifyBottomUp(x, i);
			else{
				if(x[i] > x[0]){
					swap(x, 0, i);
					heapifyTopDown(x, k-1);
				}
			}
		}
		return x[0];
	}

	public static void heapifyTopDown(int x[], int end){
		if(end==0)
			return;
		int curr = 0;

		while(curr <= parent(end)){
			int min = x[curr];
			int lc_index = left_child(curr);
			int rc_index = right_child(curr);

			if(lc_index <= end){
				int lc = x[lc_index];
				min = Math.min(min, lc);
			}
			if(rc_index <= end){
				int rc = x[rc_index];
				min = Math.min(min, rc);
			}

			if(lc_index <= end && min == x[lc_index]){
				swap(x, lc_index, curr);
				curr = lc_index;
			}
			else if(rc_index<=end && min == x[rc_index]){
				swap(x, rc_index, curr);
				curr = rc_index;
			}
			else
				break;
		}
	}

	public static void heapifyBottomUp(int x[], int index){
		while(index!=0 && x[index] < x[parent(index)]){
			//System.out.println("index="+index);
			swap(x, index, parent(index));
			index = parent(index);
			
		}
	}

	public static void swap(int x[], int i, int j){
		if(x[i] == x[j])
			return;
		x[i] = x[i] + x[j];
		x[j] = x[i] - x[j];
		x[i] = x[i] - x[j];
	}

	public static int left_child(int x){return 2*x+1;}
	public static int right_child(int x){return 2*x+2;}
	public static int parent(int x){return (x-1)/2;}
}