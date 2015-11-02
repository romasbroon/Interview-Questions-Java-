class SlidingMax{
	public static void main(String args[]){

	}

	//Return array containing max in windows of size k
	public static int[] getMax(int x[], int k){
		int ans[] = new int[x.length - k + 1];
		int n = x.length;
		//Priority queue of k elems at a time.
		int pq[] = new int[n];
		for(int i=0;i<=(n-k);i++){
			if(i<k){
				pq[i] = 
			}
		}
	}

	//Return max elem (root)
	public static int getMax(int pq[], int root){
		return pq[root];
	}

	//k = heapsize
	public static void heapifyTopDown(int pq[], int k){
		int curr = 0;
		while(curr <= parent(k)){
			int max = pq[curr];
			int lc = pq[leftChild(curr)];
			int rc = pq[rightChild(par)];
			if(lc < k && pq[lc] > max)
				max = pq[lc];
			if(rc < k && pq[rc] > max)
				max = pq[rc];
			if(max == pq[lc]){
				swap(pq, lc, curr);
				curr=lc;
			}
			else if(max == pq[rc]){
				swap(pq, rc, curr);
				curr=rc;
			}
			else
				break;
		}
	}

	public static void heapifyBottomUp(int pq[], int index, int root){
		int par = par(index);
		while(par>=root){
			if(pq[par] < pq[index]){
				swap(pq, par, index);
				index = par;
				par = par(index); 
			}
			else
				break;
		}
	}

	public static void swap(int pq[], int a, int b){
		int temp=pq[a];
		pq[a] = pq[b];
		pq[b] = temp;
	}

	public static int leftChild(int par){
		return 2*par+1;
	}

	public static int rightChild(int par){
		return 2*par+2;
	}

	public static int parent(int child){
		return child/2;
	}
}