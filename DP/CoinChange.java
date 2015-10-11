import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;

class CoinChange
{
	static int x[] = {1,2,5,10,20,50,100,200};
	static BigInteger table[][]=null;
	public static void main(String args[])throws IOException	
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder ans = new StringBuilder();
		int max=-1;
		int nums[]= new int[t];
		for(int i=0;i<t;i++)
		{
			int n = Integer.parseInt(br.readLine());
			nums[i]=n;
			if(n>max)
				max=n;
		}

		int m = x.length;
		table = new BigInteger[max+1][m];
		ways(max);
		
		for(int i=0;i<t;i++)
		{
			int n = nums[i];
			BigInteger temp = table[n][m-1];
			temp = temp.mod(new BigInteger("1000000007"));
			ans.append(temp.toString()+"\n");
		}
		System.out.println(ans);
	}//main

	public static void ways(int n)
	{
		int m = x.length;
		
		for(int i=0;i<m;i++)
			table[0][i]=new BigInteger("1");

		for(int i=1;i<=n;i++)
			for(int j=0;j<m;j++)
			{
				BigInteger with_cur_coin=new BigInteger("0");
				if(i-x[j]>=0)
					with_cur_coin = table[i-x[j]][j];
				BigInteger without_cur_coin=new BigInteger("0");
				if(j>=1)
					without_cur_coin = table[i][j-1];
				table[i][j] = with_cur_coin.add(without_cur_coin);
			}
		//return table[n][m-1];
	}
}