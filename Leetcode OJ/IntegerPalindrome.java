//Check if an integer is palindrome WITHOUT using extra space

class IntegerPalindrome{
	public static void main(String args[]){
		int n = Integer.parseInt(args[0]);
		if(isPalin(n))
			System.out.println("Palindrome.");
		else
			System.out.println("Not Palindrome");
	}

	public static boolean isPalin(int x){
		if(x>=0 && x<10)
			return true;
		if(x<10)
			return false;
		int lp = (int)Math.pow(10.0, numDigits(x)-1);
		int rp=10;
		while(lp>=rp){


			int ld = x/lp;
			int rd = x%rp;
			//System.out.println("ld="+ld+" rd="+rd);
			if(ld != rd)
				return false;
			
			x = x%lp;
			x = x/rp;
			lp = lp/100;
		}
		return true;

	}

	public static int numDigits(int x){
		int num=0;
		while(x>0){
			num++;
			x/=10;
		}
		return num;
	}
}