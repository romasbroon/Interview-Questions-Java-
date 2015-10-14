class LongestSubstringEqualSums{
	public static void main(String args[]){
		String input = args[0];
		System.out.println("Answer: "+findMaxSubstring(input));
	}	

	public static String findMaxSubstring(String s){

		int n = s.length();
		int sum[] = new int[n];
		sum[0] = s.charAt(0)-'0';
		for(int i=1;i<n;i++)
			sum[i] = sum[i-1] + s.charAt(i) - '0';
		int max=0,maxL=-1, maxR=-1;

		for(int i=0;i<n-1;i++){
			int diff_sum=0;
			if(i!=0)
				diff_sum = sum[i-1];

			for(int j=i+1;j<n;j+=2){
				int left_end = i+(j-i+1)/2 -1;
				int left_sum = sum[left_end] - diff_sum;
				int right_sum = sum[j] - sum[left_end];
				if(left_sum==right_sum)
					if(max < j-i+1){
						max = j-i+1;
						maxL = i;
						maxR = j;
					}
			}
		}
		if(maxL!=-1 && maxR!=-1)
			return s.substring(maxL, maxR+1);
		else 
			return null;

	}
}