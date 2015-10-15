class MaxSumIncSubseq{
	public static void main(String args[]){
		int x[]={100,90,80,70};
		System.out.println("Max sum increasing subsequence is: "+maxSeq(x));
	}


	public static int maxSeq(int x[]){
		int n = x.length;
		//Where max[i] is the max sum for a subsequence ending in x[i]
		int max[] = new int[n];
		max[0] = x[0];
		int ans=max[0];
		for(int i=1;i<n;i++){
			int cur_max = x[i];
			for(int j=i-1;j>=0;j--){
				
				if(x[i] >= x[j]){
					if(cur_max < max[j] + x[i])
						cur_max = max[j] + x[i];
				}
			}
			max[i] = cur_max;
			if(max[i] > ans)
				ans = max[i];
		}
		return ans;
	}
}