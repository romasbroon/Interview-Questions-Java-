class MaxProductSubarray{
	public static void main(String args[]){

	}

	public static int maxProd(int x[]){

	}

	//Finds max prod in an array with no 0s in it
	public static int maxProdHelper(int x[], int prod[], int start, int end){
		if(start==end)
			return x[start];
		int leftneg = -1, rightneg=-1, neg_count=0;
		for(int i=start;i<=end;i++){
			if(x[i] < 0){
				if(leftneg==-1)
					leftneg=i;
				else
					rightneg=i;
				neg_count++;
			}
		}
		int ans=1;
		if(neg_count%2 == 0){
			ans = start!=0 ? prod[end]/prod[start-1] : prod[end];
		}
		else{
			//Leaving out leftmost negative num
			int prod1 = prod[end]/prod[leftneg];
			int prod2 = leftneg!=0 ? prod[leftneg-1] ? Integer.MIN_VALUE;
			//Leaving out rightmost negative num
			int prod3 = start!=0 ? prod[rightneg-1]/prod[start-1] : prod[rightneg-1];
			int prod4 = 
			ans = Math.max(prod1, prod2);
		}
		return ans;
	}
}