import java.math.BigInteger;
class Equalibrium{

	public static void main(String args[]){
		int x[] = {-500, -1000000, 1, -500, -1000000};
		System.out.println("Ans: "+solution(x));
	}

	public static int solution(int A[]){
		int n = A.length;
        BigInteger sums[] = new BigInteger[n];
        for(int i=0;i<n;i++){
            if(i==0)
                sums[i] = new BigInteger(Integer.toString(A[i]));
            else
                sums[i] = sums[i-1].add(new BigInteger(Integer.toString(A[i])));        
        }
        BigInteger zero = new BigInteger("0");
        
        for(int i=0;i<n;i++){
            BigInteger leftsum = i!=0 ? sums[i-1] : new BigInteger("0");
            BigInteger rightsum = i!=n-1 ? sums[n-1].subtract(sums[i]) : new BigInteger("0");
            
            //System.out.println("i= "+i+" lsum="+leftsum+" rsum="+rightsum);
            if(leftsum.equals(rightsum))
                return i;
        }    
        
        return -1;
	}

}