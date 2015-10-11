import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;


class PrintSpiralMatrix{
	
	static int m=3;
	static int n=6;
	static int matrix[][] = new int[m][n];
	public static void main(String args[])throws IOException{

		//Initializing matrix
		BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		int in=-1;
		String str=null;
		while((str = br.readLine())!=null)
		{
			in++;
			String s[] = str.split(" ");
			for(int j=0;j<s.length;j++)
				matrix[in][j] = Integer.parseInt(s[j]);
		}

		int nr=m-1,nc=n-1;

		for(int i=0;i<=m/2;i++){ //No of borders to print
			nr-=2*i;
			nc-=2*i;

			//Print topmost row
			for(int j=0;j<nc;j++)
				System.out.print(matrix[i][i+j]+" ");
		
			//Print rightmost col
			for(int j=0;j<nr && ((i+j)<=(m-1-i));j++)
				System.out.print(matrix[i+j][n-1-i]+" ");
		
			//Print bottom row
			for(int j=0;j<nc;j++)
				System.out.print(matrix[m-1-i][n-1-j]+" ");

			for(int j=0;j<nr;j++)
				System.out.print(matrix[m-1-j][i]+" ");

		}


	}//main
}