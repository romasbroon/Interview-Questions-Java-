class Test{
	public static void main(String args[]){
		String str = args[0];
		System.out.println("Ans: "+longestPalindrome(str));
	}

	public static String longestPalindrome(String s) {
        int n = s.length();
        int maxL=0, maxR=0, max=1;
        
        //Consider strings of odd length
        for(int i=1;i<n-1;i++){
            int l_index=i-1;
            int r_index=i+1;
            while(l_index>=0 && r_index<=n-1 && s.charAt(l_index)==s.charAt(r_index))
            {
                if(r_index-l_index+1 > max){
                    max = r_index-l_index+1;
                    maxL = l_index;
                    maxR = r_index;
                }
                l_index--;
                r_index++;
            }
        }
        
        //Consider strings of even length
        for(int i=0;i<n-1;i++){
            if(s.charAt(i)==s.charAt(i+1)){
                 if(max<2){
                    max=2;
                    maxL=i;
                    maxR=i+1;
                }
                int l_index=i-1;
                int r_index=i+2;
                while(l_index>=0 && r_index<=n-1 && s.charAt(l_index)==s.charAt(r_index))
                {
                    if(r_index-l_index+1 > max){
                        max = r_index-l_index+1;
                        maxL = l_index;
                        maxR = r_index;
                    }
                    l_index--;
                    r_index++;
                }    
            }
        }
        return s.substring(maxL, maxR+1);
    }//longestPalindrome()
}