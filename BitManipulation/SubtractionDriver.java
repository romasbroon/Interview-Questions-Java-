
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException; 

class SubtractionDriver
{
	public static void main(String args[])throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter two nos: \n");

		int a=Integer.parseInt(br.readLine());
		int b=Integer.parseInt(br.readLine());

		int ans = Addition.add(a,(Addition.add(~b,1)));
		System.out.println(ans);

	}	

	
}
