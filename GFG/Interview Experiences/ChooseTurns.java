//Question Link: 
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


class ChooseTurns{
	static int[][] buf;
	static int n;
	static int x[];
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter number of elems: ");
		n = Integer.parseInt(br.readLine());
		x= new int[n];
		buf = new int[n][n];
		
		System.out.println("Enter space separated elements for array.");
		String s[] = br.readLine().split("\\s+");
		for(int i=0;i<n;i++){
			x[i] = Integer.parseInt(s[i]);
		}

		int ans = max();
		System.out.println("Answer: "+ans);

	}//main

	public static int max(){
		for(int size = 2; size <= n; size+=2){
			for(int start=0; (start+size-1) < n; start++){
				int end = start+size-1;
				if(size==2){
					buf[start][end] = Math.max(x[start], x[end]);
				}
				else{
					int v1 = Math.min(buf[start+2][end],buf[start+1][end-1])+x[start];
					int v2 = Math.min(buf[start+1][end-1],buf[start][end-2])+x[end];
					buf[start][end] = Math.max(v1, v2);
				}
			}
		}

		System.out.println("Printing buffer.");
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++)
				System.out.print(buf[i][j]+" ");
			System.out.println();
		}

		return buf[0][n-1];
	}//max
}