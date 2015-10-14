class KSmallest{
	public static void main(String args[]){
		int x[] = {7,10,4,3,20,15};
		System.out.println("Ans: "+ksmall(x, 3));
	}

	public static int ksmall(int x[], int k){
		int n = x.length;
		
		for(int i=0; i<n; i++){
			if(i>=k && x[i] < x[0])
				swap(x,i,0);
			heapify(x, Math.min(i+1,k));
			printHeap(x);
		}
		return x[0];
	}
	public static void printHeap(int x[]){
		for(int i=0;i<x.length;i++)
			System.out.print(x[i]+" ");
		System.out.println();
	}

	public static void heapify(int x[], int heapsize){
		int curr_pos=0;
		while(curr_pos < heapsize){
			int left_i = 2*curr_pos+1;
			int right_i = 2*curr_pos+2;

			if(x[left_i] > x[curr_pos] && left_i < heapsize){
				swap(x, left_i, curr_pos);
				curr_pos = left_i;
			}
			else if(x[right_i] > x[curr_pos] && right_i < heapsize){
				swap(x, right_i, curr_pos);
				curr_pos = right_i;
			}
			else
				break;		
		}
	}

	public static void swap(int x[], int pos1, int pos2){
		x[pos2] += x[pos1];
		x[pos1] = x[pos2] - x[pos1];
		x[pos2] = x[pos2] - x[pos1];
	}
}