import java.io.*;
import java.util.*;

class LCS
{
	static int buf[][] = null;

	public static void main(String args[])throws IOException	
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str1 = br.readLine();
		String str2 = br.readLine();

		buf = new int[str1.length()+1][str2.length()+1];
		for(int i=0;i<=str1.length();i++)
			for(int j=0;j<=str2.length();j++)
			{
				if(i==0 || j==0)
					buf[i][j]=0;
				else
					buf[i][j]=-1;
			}
			

		int ans = findLCSLength(str1, str2);
		System.out.println(ans);	

		//Printing the solution
		char c[] = printSol(str1, str2, ans);
		

		System.out.println(new String(c));		
	}

	public static int findLCSLength(String s1, String s2)
	{


		int len1 = s1.length();
		int len2 = s2.length();
		int ans=0;

		if(buf[len1][len2]!=-1)
			return buf[len1][len2];

		if(s1.charAt(len1-1)==s2.charAt(len2-1))
			ans = 1+findLCSLength(s1.substring(0,len1-1), s2.substring(0,len2-1));
		else
		{
			int a = findLCSLength(s1.substring(0,len1-1), s2);
			int b = findLCSLength(s1, s2.substring(0, len2-1));
			ans = Math.max(a,b);
		}
		buf[len1][len2] = ans;
		return ans; 
	}

	public static char[] printSol(String s1, String s2, int ans_len)
	{
		char c[] = new char[ans_len];
		int m = s1.length();
		int n = s2.length();
		int j = ans_len-1;
		while(j>=0)
		{
			if(s1.charAt(m-1)==s2.charAt(n-1))
			{
				c[j] = s1.charAt(m-1);	
				j--;m--;n--;
			}
			else
			{
				if(buf[m][n-1]>buf[m-1][n])
					n--;
				else
					m--;
			}
		}
		return c;
	}
}