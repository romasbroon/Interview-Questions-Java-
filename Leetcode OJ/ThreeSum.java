import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class SumPair{
	int min, max;
	SumPair(int a, int b){min=a; max=b;}
}
class ThreeSum{
	public static void main(String args[]){
		int x[] = {0, -1 , 1};
		List<List<Integer>> ans = getTriplets(x);
		for(List<Integer> triplet : ans){
			for(int a: (ArrayList<Integer>)triplet)
				System.out.print(a+" ");
			System.out.println();
		}
	}


	public static List<List<Integer>> getTriplets(int x[]){
		Arrays.sort(x);
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		for(int i=0; i<x.length-2; i++){
			if(i!=0 && x[i]==x[i-1])
				continue;
			int balance_sum = -1*x[i];
			ArrayList<SumPair> pairs = getPair(balance_sum, x, i+1, x.length-1);
			if(pairs.size() > 0){
				for(SumPair pair : pairs){
					result.add(addAll(x[i], pair));
				}
			}
		}
		return result;
	}

	public static ArrayList<SumPair> getPair(int sum, int x[], int start, int end){
		ArrayList<SumPair> ans = new ArrayList<SumPair>();
		while(start<end){
			if(x[start]+x[end] == sum){
				ans.add(new SumPair(x[start], x[end]));
				int curr_start = x[start];
				int curr_end = x[end];
				while(start<end && x[start]==curr_start)
					start++;
				while(start<end && x[end]==curr_end)
					end--;
			}
			else if(x[start] + x[end] < sum)
				start++;
			else
				end--;
		}
		return ans;
	}

	public static ArrayList<Integer> addAll(int a, SumPair pair){
		ArrayList<Integer> result = new ArrayList<Integer>();
		result.add(a);
		result.add(pair.min);
		result.add(pair.max);
		return result;
	}
}