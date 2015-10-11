import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException; 

class Multiplication
{
	public static int multiply(int a, int b)
	{
		int sum=0;
		int counter=0;
		while(b!=0)
		{
			int bit = b & 1;
			if(bit==1)
			{
				sum=Addition.add(sum,a<<counter);
			}
			counter=Addition.add(counter,1);
			b=b>>1;
		}
		return sum;
	}	
}


class MultiplicationDriver
{
	public static void main(String args[])throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter two nos: \n");

		int a=Integer.parseInt(br.readLine());
		int b=Integer.parseInt(br.readLine());

		int ans = Multiplication.multiply(a,b);
		

		System.out.println("My ans: "+ans);	
	}
}