import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.ArrayList;

class SmallSubstring{
	static private int ALPHABET_SIZE = 26;
	public static void main(String argss[])throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter large and small substrings.");
		String s1 = br.readLine();
		String s2 = br.readLine();
		System.out.println("Smallest substring: "+smallSubstring(s1, s2));
	}


	public static String smallSubstring(String s1, String s2){
		int shash[] = new int[ALPHABET_SIZE];
		int lhash[] = new int[ALPHABET_SIZE];

		//Hash the smaller string
		for(int i=0; i <s2.length();i++)
			shash[s2.charAt(i)-'a']++;
		
		int flag = 0;
		int minL = 0;
		int minR = Integer.MAX_VALUE;
		int left=0;
		char first_char = s2.charAt(0);

		for(int i=0;i<s1.length();i++){
			char curr = s1.charAt(i);
			if(shash[curr-'a'] > 0){
				lhash[curr-'a']++;
				if(lhash[curr-'a'] > shash[curr-'a']){
					if(curr==first_char){
						left = i;
						lhash[curr-'a']--;
					}
					else{
						flag=0;
						reset(lhash);
					}
				}
				else
				{
					if(curr==first_char && flag==0){
						left = i;
						flag=1;
					}

					boolean check = checkHash(lhash, shash);
					if(check){
						if(i - left < minR - minL){
							minL = left;
							minR = i;
							flag=0;
							reset(lhash);
						}
					}					
				}
			}
		}//for loop to traverse larger string

		return s1.substring(minL, minR+1);

	}

	public static void reset(int hash[]){
		for(int i=0;i<hash.length;i++)
			hash[i]=0;
	}

	public static boolean checkHash(int hash1[], int hash2[]){
		int i=0;
		for(i=0;i<ALPHABET_SIZE;i++){
			if(hash1[i]!=hash2[i])
				break;
		}
		if(i==26)
			return true;
		else
			return false;
	}

}