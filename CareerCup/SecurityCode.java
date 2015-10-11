import java.io.*;
import java.util.HashSet;
class SecurityCode{
	public static void main(String args[])throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String entered = br.readLine();
		String orig = "12646";
		System.out.println(isSecure(orig, entered));

	}

	public static boolean isSecure(String original, String entered){
		int i=0;
		int j=0;
		HashSet<Character> invalid = new HashSet<Character>();
		HashSet<Character> tillnow = new HashSet<Character>();
		char o[] = original.toCharArray();
		char e[] = entered.toCharArray();

		while(invalid.size()<=1 && i<o.length){
			
			if(j<e.length){
				if(o[i]==e[j]){
					if(invalid.contains(o[i]))
						return false;
					tillnow.add(o[i]);

					i++;
					j++;
				}
				else{
					invalid.add(o[i]);
					i++;
				}
			}
			else
			{
				if(tillnow.contains(o[i]))
					return false;
				invalid.add(o[i]);
				i++;
			}
			
		}
		if(invalid.size()>1 || j<e.length)
			return false;
		return true;

	}
}