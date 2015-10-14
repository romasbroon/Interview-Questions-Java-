//PROGRAM: Find if there exists a subset of an array which sums to a given k.

class BalancedPartition{
	public static void main(String args[]){
		int x[] = {1,5,11,5};
		System.out.println(findSubset(Integer.parseInt(args[0]),x));
	}

	public static boolean findSubset(int sum, int x[]){
		int n = x.length;
		boolean buf[][] = new boolean[n+1][sum+1];

		for(int i=0;i<=sum;i++){ // Sums
			for(int j=0;j<n;j++){
				if(i==0)
					buf[j][i] = true;
				else{
					if(j==0){
						if(x[j] == i)
							buf[j][i] = true;
					}
					else{
						buf[j][i] = buf [j-1][i];
						if(x[j] <= i)
							buf[j][i] = buf[j][i] || buf[j-1][i-x[j]];
					}

				}		

			}//inner for

		}//outer for
		return buf[n-1][sum];
	}
}//class