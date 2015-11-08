class SelectionSortImplementation implements SortingPrograms{
	public void sort(int x[]){
		int n = x.length;
		for(int i=0;i<n-1;i++){
			int min = i;
			for(int j=i;j<n;j++){
				if(x[j] < x[min])
					min = j; 
			}
			//Swap min with i-1
			if(x[min] < x[i]){
				int temp = x[i];
				x[i] = x[min];
				x[min] = temp;	
			}
			
			//print(x);
		}
		
	}

	private void print(int x[]){
		for(int i=0;i<x.length;i++)
			System.out.print(x[i]+" ");
		System.out.println();
	}
}

class SelectionSort{
	public static void main(String args[]){
		int x[] = {10,9,8,7,6};
		SelectionSortImplementation obj = new SelectionSortImplementation();
		obj.sort(x);
		for(int i=0;i<x.length;i++)
			System.out.print(x[i]+" ");
		System.out.println();
	}
}