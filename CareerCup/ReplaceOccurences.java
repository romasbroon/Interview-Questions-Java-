class ReplaceOccurences{
	public static void main(String args[]){

		String s = "A fox jumped over a bridge on the box";
		int num = 0;
		int len  = s.length();
		for(int i=0;i<len;i++){
			if(s.charAt(i)=='a' || s.charAt(i)=='A')
				num++;
		}

		char c[] = new char[len+2*num];
		int j = c.length-1;
		int i=len-1;

		while(i>=0){
			if(s.charAt(i)=='a'){
				c[j]='e';c[j-1]='h';c[j-2]='t';
				j=j-3;
			}
			else if (s.charAt(i)=='A'){
				c[j]='e';c[j-1]='h';c[j-2]='T';
				j=j-3;
			}
			else{
				c[j]=s.charAt(i);
				j--;
			}
			i--;
		}
		System.out.println(new String(c));

	}//main
}