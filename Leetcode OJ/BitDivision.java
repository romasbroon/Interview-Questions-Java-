class BitDivision{
	public static void main(String args[]){
		int dividend = Integer.parseInt(args[0]);
		int divisor = Integer.parseInt(args[1]);

		System.out.println("Ans: "+divideHelper(dividend, divisor));
	}

	public static int divideHelper(int dividend, int divisor){
		//Changing to negative integers
		int a = dividend > 0 ? -dividend : dividend;
		int b = divisor > 0 ? -divisor : divisor;
		int multiplier = (dividend < 0 && divisor >0) || (dividend>0 && divisor<0) ? -1 : 1;
		return multiplier*divide(a,b);
	}
	public static int divide(int a, int b){
		if(a==0 || a > b)
			return 0;
		if(b==1)
			return a;
		if(a == Integer.MIN_VALUE && b==-1)
			return Integer.MAX_VALUE;
		//Not sure if this is needed
		if(b == Integer.MIN_VALUE)
			return 0;

		int quotient = 1;
		int shifts=0;
		int min_divisor = Integer.MIN_VALUE>>1;
		int divisor = b;
		while(b > a && b >= min_divisor){
			b = b<<1;
			shifts++;
		}
		if(b < a){
			b = b>>1;
			shifts--;	
		}
		//System.out.println("a: "+a+" b: "+b);
		quotient = 1<<shifts;

		int remainder = a-b;
		while(remainder <= divisor){
			//System.out.println("rem: "+remainder+" b: "+b);
			b>>=1;
			shifts--;
			if(remainder <= b){
				quotient |= 1<<shifts;
				remainder = remainder - b;
			}
		}
		return quotient;

	}
}