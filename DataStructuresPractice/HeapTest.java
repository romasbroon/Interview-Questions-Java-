//A min heap
class Heap{
	int capacity = 100;
	int size;
	int x[];
	Heap(){
		size = 0;
		x = new int[capacity];
	}
	//Insert a new key
	public void insert(int key){
		x[size++] = key;
		if(size==1)
			return;
		else
			heapify(size-1);
	}

	public void heapify(int index){

		while(index!=0 && x[index] < x[parent(index)]){
			swap(index, parent(index));
			index = parent(index);
		}
	}

	public int parent(int index){return (index-1)/2;}
	public int leftChild(int index){return 2*index+1;}
	public int rightChild(int index){return 2*index+2;}

	public void swap(int index1, int index2){
		if(index1 == index2)
			return;
		x[index1] += x[index2];
		x[index2] = x[index1] - x[index2];
		x[index1] = x[index1] - x[index2];
	}

	public void printHeap(){
		for(int i=0;i<size;i++)
			System.out.print(x[i]+" ");
	}

	//removes root
	public int extractMin(){
		if(size==0)
			return -1;
		int return_val = x[0];
		x[0] = x[size-1];
		size--;
		//Maintain heap property
		heapifyTopDown(0);
		return return_val;		
	}//extractMin


	public void heapifyTopDown(int parent){
		int lc = leftChild(parent);
		int rc = rightChild(parent);
		int min_index=parent;
		if(lc < size && x[parent] > x[lc])
			min_index = lc;
		if(rc < size && x[min_index] > x[rc])
			min_index = rc;
		if(min_index!=parent){
			swap(min_index, parent);
			heapifyTopDown(min_index);
		}
	}

}


class HeapTest{
	public static void main(String args[]){
		Heap heap = new Heap();
		int x[] = {5,2,4,1,7,10,11};
		for(int i: x)
			heap.insert(i);
		heap.printHeap();	
		System.out.println();
		for(int i=0;i<7;i++)
			System.out.println(heap.extractMin());
	}
}