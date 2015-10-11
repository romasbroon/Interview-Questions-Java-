import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.ArrayList;

class SmallEOSubstring{
	public static void main(String argss[])throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		System.out.println("Smallest substring: "+smallSubstring(input));
	}


	public static String smallSubstring(String s){
		ArrayList<Integer> e_occurences = new ArrayList<Integer>();
		ArrayList<Integer> o_occurences = new ArrayList<Integer>();

		for(int i=0;i<s.length();i++){
			if(s.charAt(i) == 'e')
				e_occurences.add(i);
			if(s.charAt(i) == 'o')
				o_occurences.add(i);			

		}

		int n = e_occurences.size();
		int m = o_occurences.size();
		int i=0,j=0;
		int ei=0,oi=0;
		int diff = Integer.MAX_VALUE;

		while(i<n && j<m){
			int a = e_occurences.get(i);
			int b = o_occurences.get(j);
			int curr_diff = Math.abs(a-b);
			if(curr_diff < diff){
				System.out.println(curr_diff);
				diff = curr_diff;
				ei = a; oi = b;
			}
			
			if(a<b)
				i++;
			else
				j++;
		}
		return s.substring(Math.min(ei,oi), Math.max(ei,oi)+1);
	}
}