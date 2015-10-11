import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
class ReverseStringWords{

	public static void main(String args[])throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter a string: ");
		String input = br.readLine();
		String rev = reverse(input);
		System.out.println("Reversed words: "+rev);
	}

	public static String reverse(String input){
		int n = input.length();
		char ans[] = new char[n];
		StringBuffer current = new StringBuffer();
		int i=0;
		while(i<=n){
			if(i==n){
				insertAt(ans, n-i, current.toString());
				break;
			}
			else{
				if(input.charAt(i)==' '){
					insertAt(ans, n-i, current.toString());
					current = new StringBuffer();
				}
				else
					current.append(input.charAt(i));
				i++;
			}
		}
		return new String(ans); 
	}//reverse()

	public static void insertAt(char[] s, int start, String ins){
		int end = start+ins.length()-1;
		for(int i=start,j=0; i<=end ;i++,j++)
			s[i] = ins.charAt(j);
		if(start!=0)
			s[start-1] = ' ';
	}//insertAt()


}