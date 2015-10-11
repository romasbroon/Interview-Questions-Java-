class MinStepsToEnd
{
	//static int x[] = {1,3,5,8,9,2,6,7,6,8,9};
	static int x[] = {5,1,1,1,2,0,1,1};
	static int INT_MAX=10000;

	public static void main(String args[])
	{
		System.out.println("Min steps to end: "+steps());
	}

	public static int steps()
	{
		int n = x.length;
		int table[] = new int[n];
		table[0]=0;

		for(int i=1;i<n;i++)
		{
			if(x[i]==0)
			{
				table[i] = INT_MAX;
				continue;
			}
			int min = INT_MAX;
			for(int j=0;j<i;j++)
			{
				if(x[j]>=(i-j))
					if((table[j]+1)<min)
						min = table[j]+1;
			}
			table[i]=min;
		}
		return table[n-1];

	}
}