import java.io.*;
import java.util.*;
class LongestPalinSubsequence
{
	static HashMap<String, String> solutions = new HashMap<String, String>();

	public static void main(String args[])throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String ans = findPalin(str);
		System.out.println(ans);
	}

	public static String findPalin(String str)
	{
		if(solutions.containsKey(str))
			return solutions.get(str);

		int n = str.length();
		if(n==1)
			return str;


		if(str.charAt(n-1)==str.charAt(0))
		{
			char c=str.charAt(0);
			StringBuilder sb = new StringBuilder();
			sb.append(c);
			String temp_q = str.substring(1,n-1);
			String temp_a = findPalin(temp_q);
			sb.append(temp_a);
			solutions.put(temp_q,temp_a);
			sb.append(c);
			return sb.toString();
		}	
		else
		{
			String str1 = findPalin(str.substring(0,n-1));
			solutions.put(str.substring(0,n-1), str1);
			String str2 = findPalin(str.substring(1));
			solutions.put(str.substring(1), str2);
			return str1.length()>str2.length() ? str1 : str2;

		}
	}
}