import java.util.ArrayList;
import java.util.HashMap;
class StringPermuteConstraints{
	
	public static void main(String args[]){
		String test = "abc";

		ArrayList<String> result = addConstraint(test); 
		for(String ans: result)
			System.out.println(ans);
		
		System.out.println(result.size());
	}//main

	public static ArrayList<String> addConstraint(String str){
		StringBuilder sb = new StringBuilder();
		int n = str.length();
		HashMap<Integer, Character> old = new HashMap<Integer, Character>();

		for(int i=0;i<n;i++){
			char c = str.charAt(i);
			if((int)c >= 97)
				sb.append(c);			
			else
				old.put(i, c);
		}
		ArrayList<String> sub_result = permute(sb.toString());
		ArrayList<String> result = new ArrayList<String>();
		for(String s : sub_result){
			char x[] = new char[n];		
			int counter=0;

			for(int i=0;i<n;i++){
				char c = str.charAt(i);

				if((int)c >= 97){
					x[i] = s.charAt(counter++);
				}
				else
					x[i] = str.charAt(i);
			}
			result.add(new String(x));

		}
		return result;


	}


	public static ArrayList<String> permute(String str){
		ArrayList<String> result = new ArrayList<String>();

		//Base case
		if(str.length()==1){
			result.add(str);
			return result;
		}

		for(int i=0;i<str.length();i++){
			char first = str.charAt(i);
			String pre = str.substring(0,i);
			String suf = str.substring(i+1);
			String rec_string = pre+suf;
			ArrayList<String> sublist = permute(rec_string);
			for(String s: sublist){
				result.add(first+s);
			}

		}
		return result;
	}//permute()

}