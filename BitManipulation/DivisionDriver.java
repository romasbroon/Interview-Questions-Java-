import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


class Division
{
	static int divide(int a, int b)
	{
		int oldb=b;
		if(b==0)
			return -1;

		int greatestQuotient = 1;
		int quotient = 0;

		while(b<=a)
		{
			b=b<<1;
			greatestQuotient=greatestQuotient<<1;
		}
		//System.out.println(greatestQuotient);
		greatestQuotient = greatestQuotient>>1;
		b= b>>1;

		System.out.println(greatestQuotient);
		System.out.println(b);
		while(b>=oldb)
		{
			

			quotient=quotient|greatestQuotient;
			a=Addition.add(a,Addition.add(~b,1));
			b=b>>1;
			greatestQuotient=greatestQuotient>>1;

		}
		return quotient;

	}
}
class DivisionDriver
{
	public static void main(String args[]) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());

		int ans = Division.divide(a,b);
		if(ans!=-1)
			System.out.println("Answer = "+ans);
		else
			System.out.println("Invalid divisor");
	}
}