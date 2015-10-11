
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException; 

class Addition
{
	public static int add(int a, int b)
	{
		if(a==0 || b==0)
			return a==0? b : a;

		int sum = a ^ b;
		int carry = a & b;
		return add(sum,carry<<1);		
	}
}


class AdditionDriver
{
	public static void main(String args[])throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter two nos: \n");

		int a=Integer.parseInt(br.readLine());
		int b=Integer.parseInt(br.readLine());

		int ans = Addition.add(a,b);
		

		System.out.println("My ans: "+ans);
		System.out.println("Actual ans: "+(a+b));
	}	



}
