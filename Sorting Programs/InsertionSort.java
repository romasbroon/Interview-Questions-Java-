class InsertionSortImplementation implements SortingPrograms{
	public void sort(int x[]){
		int n = x.length;
		for(int i=1;i<n;i++){
			int current_elem = x[i];
			int current_index = i;
			for(int j=i-1;j>=0;j--){
				if(current_elem < x[j]){
					int temp = x[j];
					x[j] = x[current_index];
					x[current_index] = temp;
					current_index = j;
					current_elem = x[current_index];
				}					
			}			
		}
	}	
}

class InsertionSort{
	public static void main(String args[]){
		int x[] = {5,4,3,2,1};
		InsertionSortImplementation obj = new InsertionSortImplementation();
		obj.sort(x);
		for(int i=0;i<x.length;i++)
			System.out.print(x[i]+" ");
		System.out.println();
	}
}