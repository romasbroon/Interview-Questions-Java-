import java.math.BigInteger;

class ReverseInt{
	public static void main(String args[]){
		int x = -2147483648;
		System.out.println(reverse(x));
	}


	public static int reverse(int x) {
        if(x==0 || x==Integer.MIN_VALUE)
            return 0;
        

        int multiplier = x/Math.abs(x);
        String s = Integer.toString(Math.abs(x));
        String rev_s = new StringBuffer(s).reverse().toString();
        BigInteger orig = new BigInteger(rev_s);
        if(multiplier==-1)
            orig=orig.multiply(new BigInteger("-1"));
        BigInteger largest_int = new BigInteger(Integer.toString(Integer.MAX_VALUE)); 
        BigInteger smallest_int = new BigInteger(Integer.toString(Integer.MIN_VALUE));
        if(orig.compareTo(largest_int) == 1 || orig.compareTo(smallest_int) == -1)
            return 0;
        return Integer.parseInt(orig.toString());
    }

}