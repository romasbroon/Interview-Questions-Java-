class LongestPalinSubstring{
	public static void main(String args[]){
		String input = args[0];
		System.out.println("Ans: "+maxSubstring(input));
	}

	public static String maxSubstring(String input){
		int n = input.length();
		char str[] = input.toCharArray();
		int buf[][] = new int[n][n];
		int maxL=0, maxR=0, max=0;

		for(int i=0;i<n;i++)
			buf[i][i] = 1;

		for(int i=2; i<=n; i++){ //outer loop for substring lengths
			for(int st=0; st+i-1 < n; st++){
				int end = st+i-1;
				if(str[st] != str[end]){
					buf[st][end] = Math.max(buf[st+1][end], buf[st][end-1]);
				}
				else{
					if(i==2)
						buf[st][end]=2;
					else{
						if(buf[st+1][end-1] == end-st-1)
							buf[st][end] = end-st+1;
						else
							buf[st][end] = buf[st+1][end-1];
					}
				}
				if(buf[st][end] > max){
					max = buf[st][end];
					maxL = st;
					maxR = end;
				}


			}//inner for
		}
		/*
		//Print table
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				System.out.print(buf[i][j]+" ");
			}
			System.out.println();
		}
		*/
		return input.substring(maxL, maxR+1);
	}//maxSubstring()
}