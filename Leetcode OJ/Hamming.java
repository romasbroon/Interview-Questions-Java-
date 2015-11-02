class Hamming{
	public static void main(String args[]){
		int n = 2147483648;
		System.out.println("Ans: "+hammingWeight(n));
	}

	public static long hammingWeight(int n) {
        if(n<=0)
            return 0;
        int shifter=1;
        int count=0;
        long temp = (long)n;
        for(int i=0;i<64;i++){
            if((temp>>i & 1) == 1)
                count++;
        }
        return count;
    }
}