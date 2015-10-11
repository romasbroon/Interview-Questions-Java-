import java.io.*;

class QuickSort
{
	static int x[];
	public static void main(String args[])throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the num of elements:");
		int n = Integer.parseInt(br.readLine());
		System.out.println("Enter the elements:");
		x = new int[n];
		for(int i=0;i<n;i++)
		{
			x[i] = Integer.parseInt(br.readLine());
		}

		try{
		sort(0,n-1);
		}

		catch(Exception e)
		{
		//	System.out.println(e.getMessage());

		}

		System.out.println("Sorted array is: ");
		for(int i=0;i<n;i++)
			System.out.print(x[i]+" ");
	}//main

	public static void sort(int start, int end) 
	{
		if(start==end)
			return;
		int index = partition(start, end);
		
		if(index>start)
			sort(start, index-1);	
		
		if(index<end)	
			sort(index+1, end);

	}
	public static int partition(int start, int end)
	{
		int pivot = x[end];
		int i=start-1;
		for(int j=start;j<end;j++)
		{
			if(x[j]<=pivot)
			{
				i++;
				swap(i,j);
			}
		}
		//Swap pivot with elem at i+1
		swap(i+1,end);
		return i+1;
	}

	public static void swap(int i, int j)
	{
		if(i==j)
			return;
		//System.out.println("swap indices "+i+" "+j);
		x[i]+=x[j];
		x[j]=x[i]-x[j];
		x[i]-=x[j];
		
		
	}
}