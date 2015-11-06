
class MinHeap{
	private int x[];
	private int size;
	final int capacity = 10000;

	MinHeap(){
		x = new int[capacity];
		size=0;
	}

	public int size(){
		return this.size;
	}

	public int root(){
		if(size==0)
			return -1;
		return x[0];
	}

	public void insert(int elem){
		if(size==capacity)
			return;
		x[size] = elem;
		heapifyBottomUp(size++);
	}

	public int extractMin(){
		int ret = x[0];
		if(size==1)
			size=0;
		else{
			x[0] = x[size-1];
			size--;
			heapifyTopDown(0);
		}
		return ret;
	}


	public void heapifyTopDown(int index){
		int temp = 0;
		while(temp <= parent(size-1) && size!=1){
			int left_index = leftChild(temp);
			int right_index = rightChild(temp);
			int swap_index = temp;
		
			if(x[left_index] < x[swap_index] && left_index<size)
				swap_index = left_index;
			if(x[right_index] < x[swap_index] && right_index<size)
				swap_index = right_index;

			if(swap_index==temp)
				break;
			else{
				swap(swap_index, temp);
				temp = swap_index;
			}
		}
	}

	public void heapifyBottomUp(int index){
		int temp = index;
		int par = parent(temp);
		while(par>=0){
			if(x[temp] < x[par]){
				swap(temp, par);
				temp = par;
				par = parent(par);
			}
			else
				break;
		}
	}

	public int parent(int index){
		return (index-1)/2;
	}

	public int leftChild(int par){
		return 2*par+1;
	}

	public int rightChild(int par){
		return 2*par+2;
	}

	public void swap(int index1, int index2){
		if(index1==index2)
			return;
		int temp = x[index1];
		x[index1] = x[index2];
		x[index2] = temp;
	}

	public void print(){
		for(int i=0 ; i<size;i++)
			System.out.print(x[i]+" ");
		System.out.println();
	}
}