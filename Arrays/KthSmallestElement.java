import java.io.*;

class KthSmallestElement
{
	static int x[] = {4,1,7,2,3,10,6};
	public static void main(String args[]) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine());
		int n = x.length;
		System.out.println("Ans: "+quickSelect(0,n-1,k));
	}

	//Recursive method
	public static int quickSelect(int start, int end, int k)
	{
		int index = partition(start, end);
		int num_elems = index-start+1;
		//System.out.println(index);
		if(num_elems==k)
			return x[index];
		else if(num_elems<k && index<end)//Right part
			return quickSelect(index+1,end,k-num_elems);
		else
			if(index>start)
				return quickSelect(start, index-1,k);	

		return 10000000;	
	}

	public static int partition(int start, int end)
	{
		if(start==end)
			return start;
		int pivot = x[end];
		int i=start-1;
		for(int j=start; j<end;j++)
		{
			if(x[j]<=pivot)
				swap(++i,j);
		}
		swap(++i,end);
		return i;
	}

	//Swapping INDICES i and j
	public static void swap(int i, int j)
	{
		if(i==j)
			return;
		x[i]+=x[j];
		x[j]=x[i]-x[j];
		x[i]-=x[j];
	}
}