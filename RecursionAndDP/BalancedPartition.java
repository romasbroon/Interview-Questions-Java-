//PROGRAM: Find if there exists a subset of an array which sums to a given k.

class BalancedPartition{
	public static void main(String args[]){
		int x[] = {1,5,11,5};
		System.out.println(findSubset(11,x));
	}

	public static boolean findSubset(int sum, int x[]){
		int n = x.length;
		boolean buf[][] = new boolean[n][sum+1];

		for(int i=0;i<=sum;i++){ // Sums
			for(int j=0;j<n;j++){
				if(i==0)
					buf[i][j] = true;	
				else{
					if(x[i] <= j)
						buf[i][j] = buf[n-1][j-x[i]];
					else
						buf[i][j] = j==0 ? false : buf[i][j-1];					
				}		

			}//inner for

		}//outer for
		return buf[n-1][sum];
	}
}//class