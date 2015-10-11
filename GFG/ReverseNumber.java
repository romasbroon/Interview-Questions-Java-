class ReverseNumber{
	public static void main(String args[]){
		int num=1204;
		System.out.println(rev(num));
	}

	public static int rev(int n){
		if(n/10==0)
			return n;

		int tail = rev(n/10);//Recursive call
		int temp=n;
		int pow=0;
		while((temp/=10)!=0)
			pow++;

		return ((n%10)*(int)Math.pow(10.0, (double)pow) + tail);
	}
}