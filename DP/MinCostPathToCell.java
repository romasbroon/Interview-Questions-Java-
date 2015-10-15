import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class MinCostPathToCell{
	public static void main(String args[])throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));



		int size=3;
		int costs[][] = new int[size][size];
		costs[0][0] = 1;
		costs[0][1] = 2;
		costs[0][2] = 3;
		costs[1][0] = 4;
		costs[1][1] = 8;
		costs[1][2] = 2;
		costs[2][0] = 1;
		costs[2][1] = 5;
		costs[2][2] = 3;

		System.out.println("Enter m and n: ");
		int m = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());

		System.out.println("Min cost path value: "+pathCost(costs, size, m, n));

	}


	public static int pathCost(int costs[][], int size, int m, int n){

		//m: num of rows
		//n: num of columns

		int buf[][] = new int[size][size];
		buf[0][0] = costs[0][0];

		//Initializing leftmost column
		for(int i=1; i<size; i++)
			buf[i][0] = buf[i-1][0] + costs[i][0];

		//Initializing topmost row
		for(int i=1; i<size; i++)
			buf[0][i] = buf[0][i-1] + costs[0][i];

		//Filling up buffer in bottom up manner
		for(int i=1;i<size;i++){
			for(int j=1;j<size;j++){
				buf[i][j] = min(buf[i-1][j-1], buf[i-1][j], buf[i][j-1]) + costs[i][j];
			}
		}


		//Printing buffer
		for(int i=0;i<size;i++){
			for(int j=0;j<size;j++){
				System.out.print(buf[i][j]+" ");
			}
			System.out.println();
		}
		return buf[m][n];

	}//pathCost()


	//Function to return min of 3 elems
	public static int min(int a, int b, int c){
		if(a<=b && a<=c)
			return a;
		else if(b<=a && b<=c)
			return b;
		else 
			return c;
	}
}