class NQueens
{
	static int columns[];
	public static void main(String args[])
	{
		int n = 8;
		columns = new int[n+1];
		
		place(1, n);

		for(int i=1;i<=n;i++)
			System.out.println("Queen "+i+" : "+columns[i]);


	}



	public static boolean hit(int x1, int y1, int n)
	{

		boolean flag=false;

		for(int i =1; i<=n; i++)
		{
			if(i==x1 || columns[i]==0)
				continue;

			if(columns[i]==y1 || Math.abs(x1-i)==Math.abs(y1-columns[i]))
			{
				flag=true;
				break;
			}
		}	
		

		return flag;
	}


	public static boolean place(int queen, int n)
	{
		
		for (int i=1; i<=n; i++) 
		{
			if(hit(queen, i , n))
				continue;
			
			columns[queen]=i;	
			if(queen==n)//not last queen
				return true;
			else
				if(place(queen+1, n))
					return true;
				else //WITHOUT THIS THE CODE WONT WORK, NEED TO CLEAN THE MESS MADE IN THIS ITERATION
					columns[queen]=0;
		}
		
		return false;
	}

}