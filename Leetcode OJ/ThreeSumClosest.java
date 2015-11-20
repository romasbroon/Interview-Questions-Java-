import java.util.Arrays;
class ThreeSumClosest{
	public static void main(String args[]){
		int x[] = {1,1,-1,-1,3};
		System.out.println(threeSumClosest(x, 0));
	}

	public static int threeSumClosest(int x[], int target){
		int n = x.length;
		Arrays.sort(x);
		int min_sum = x[0]+x[1]+x[2];
		for(int i=0; i<n-2; i++){
			int diff = target - x[i];
			int twoSum = twoClosestSum(x, i+1, n-1, diff);
			if(Math.abs(diff - twoSum) < Math.abs(target - min_sum))
				min_sum = x[i] + twoSum;
		}
		return min_sum;
	}

	//Returns the sum of two integers between start and end indices, such that the sum is closest to diff
	public static int twoClosestSum(int x[], int start, int end, int diff){
		int i = start, j=end;
		int twoSum = 0;
		int min = Integer.MAX_VALUE;
		while(i<j){
			int sum = x[i]+x[j];
			if(Math.abs(sum - diff) < min){
				twoSum = sum;
				min = Math.abs(sum - diff);
			}			
			if(sum > diff)
				j--;
			else
				i++;
		
		}
		return twoSum;
	}	
}