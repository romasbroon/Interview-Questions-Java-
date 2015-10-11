import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class MyQuickSort{
	public static void main(String args[])throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter number of elements: ");
		int n = Integer.parseInt(br.readLine());
		int x[] = new int[n];
		System.out.println("Enter the elems by space separation: ");
		String s[] = br.readLine().split(" ");
		for(int i=0;i<n;i++){
			x[i] = Integer.parseInt(s[i]);
		}

		quicksort(x, 0, n-1);

		System.out.println("Sorted array: ");
		for(int i=0;i<n;i++){
			System.out.print(x[i]+" ");
		}

	}//main

	public static void quicksort(int x[], int low, int high){
		if(low>=high)
			return;
		int p = partition(x, low, high);
		System.out.println("partition returned: "+p);
		quicksort(x, low, p-1);
		quicksort(x, p+1, high);
	}

	public static int partition(int x[], int low, int high){
		System.out.println("Partition for low="+low+" high="+high);
		int pivot = x[high];
		int i = low, j = high-1;
		while(i<=j){
			while(j>=low && x[j] > pivot)
				j--;
			while(i<high && x[i] <= pivot)
				i++;

			if(i<=j && i<high && j>=low)
				swap(x, i, j);
		}
		swap(x, i, high);
		return i;
	}

	public static void swap(int x[], int i, int j){
		int temp = x[i];
		x[i] = x[j];
		x[j] = temp;
	}

}
