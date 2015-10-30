import java.util.HashSet;

//Find longest substring in a string that has no repeated characters
class LongestSubstringNoRepeat{
	public static void main(String args[]){
		String input = args[0];
		int ans = findLongSubstringLinear(input);
		System.out.println(ans);

	}

	//O(n) 
	//Link: leetcode.com/discuss/60645/share-my-java-solution-using-hashset
	public static int findLongSubstringLinear(String input){
		int n = input.length();
		HashSet<Character> hs = new HashSet<Character>();
		int i=0, j=0;
		int max=1;
		while(j<n){
			
			//System.out.println("i="+i+" j="+j);
			//System.out.println("j="+j);
			if(hs.contains(input.charAt(j)) && j!=i){
				hs.remove(input.charAt(i++));	
			}
			else{
				if(j-i+1 > max)	
					max = j-i+1;
				hs.add(input.charAt(j++));
			}
		}
		return max;

	}

	//O(n^2)
	public static String findLongSubstring(String input){
		int maxlen=1;
		int max_left=0;
		int max_right=0;
		int n = input.length();
		//Checking substrings of odd length
		for(int i=1;i<n-1;i++){
			int left_start = i-1;
			int right_start = i+1;
			//Hash for current string
			char hash[] = new char[256];
			hash[input.charAt(i) -'\0'] = 1;
			while(left_start >=0 && right_start<n){
				char left_char = input.charAt(left_start);
				char right_char = input.charAt(right_start);
				if(left_char != right_char && hash[left_char-'\0']!=1 && hash[right_char-'\0']!=1){
					hash[left_char-'\0']=1;
					hash[right_char-'\0']=1;
					if(right_start - left_start +1 > maxlen){
						max_left = left_start;
						max_right = right_start;
						maxlen = right_start-left_start+1;
					}
					left_start--;
					right_start++;
				}
				else
					break;
			}
		}

		//Checking substrings of even length
		for(int i=0;i<n-1;i++){
			int j = i+1;
			int left_start = i;
			int right_start = j;
			char hash[] = new char[256];

			if(input.charAt(left_start)!=input.charAt(right_start)){
				while(left_start >=0 && right_start<n){
					char left_char = input.charAt(left_start);
					char right_char = input.charAt(right_start);
					if(left_char != right_char && hash[left_char-'\0']!=1 && hash[right_char-'\0']!=1){
						hash[left_char-'\0']=1;
						hash[right_char-'\0']=1;
						if(right_start - left_start +1 > maxlen){
							max_left = left_start;
							max_right = right_start;
							maxlen = right_start-left_start+1;
						}
						left_start--;
						right_start++;
					}
					else
						break;		
				}
			}
		}

		return input.substring(max_left, max_right+1);

	}//findLongSubstring()

}