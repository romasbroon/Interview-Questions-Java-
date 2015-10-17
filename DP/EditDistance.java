class EditDistance{
	public static void main(String args[]){

		String s1 = "zoologicoarchaeologist";
		String s2 = "zoogeologist";
		System.out.println("Edit distance: "+edit(s1, s2));
	}

	public static int edit(String word1, String word2){
		int n1 = word1.length();
        int n2 = word2.length();
        
        if(n1==0)
            return n2;
        if(n2==0)
            return n1;
        
        int edit[][] = new int[n2+1][n1+1];
        
        edit[0][0] = 0;
        //Initializing top row
        for(int i=1;i<=n1;i++)
           	edit[0][i] = i;
        for(int j=1;j<=n2;j++)
        	edit[j][0] = j;       
       
        
        for(int i=1;i<=n2;i++){
            for(int j=1;j<=n1;j++){
                if(word1.charAt(j-1)==word2.charAt(i-1))
                    edit[i][j] = edit[i-1][j-1];
                else
                    edit[i][j] = getMin(edit[i-1][j-1], edit[i-1][j], edit[i][j-1]) + 1;
            }
        }	

        return edit[n2][n1];
	}

	public static int getMin(int a, int b, int c){
        if(a<=b && a<=c)
            return a;
        else if(b<=a && b<=c)
            return b;
        else
            return c;
    }
}