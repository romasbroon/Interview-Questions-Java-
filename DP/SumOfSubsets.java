import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class SumOfSubsets
{
	static int x[] = {3, 34, 4, 12, 5, 2};
	public static void main(String args[])throws IOException	
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		boolean ans = exists(n);
		if(ans)
			System.out.println("EXISTS");
		else
			System.out.println("NOT EXISTS");
	}//main

	public static boolean exists(int n)
	{
		int m = x.length;
		boolean table[][] = new boolean[n+1][m];
		for(int i=0;i<m;i++)
			table[0][i] = true;

		for(int i=1;i<=n;i++)
			for(int j=0;j<m;j++)
			{
				boolean flag1=false,flag2=false;
				if(i-x[j]>=0)//include current elem
				{
					flag1 = (i-x[j])==0 ? true : (j>0 ? table[i-x[j]][j-1] : false);
				}
				if(j>=1)//exclude current elem
					flag2 = table[i][j-1];
				table[i][j] = flag1 || flag2;
			}
			return table[n][m-1];	


	}
}