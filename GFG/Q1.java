import java.io.*;
import java.util.*;

class Cell{
	int row;
	int col;
	int depth;
	Cell(int row, int col, int depth){
		this.row=row;
		this.col=col;
		this.depth=depth;
	}
}

public class Q1{
	static int m=4;
	static int n=6;
	static int matrix[][] = new int[m][n];
	static Queue<Cell> q = new LinkedList<Cell>();
	static int ans=0;
	static int one_count=0;

	public static void main(String args[])throws IOException{

		BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		int i=-1;
		String str=null;
		while((str = br.readLine())!=null)
		{
			i++;
			String s[] = str.split(" ");
			for(int j=0;j<s.length;j++)
				matrix[i][j] = Integer.parseInt(s[j]);
		}
		
		/*
		//Print matrix

		for(i=0;i<m;i++){
			for(int j=0;j<n;j++)
			{
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}		
		*/

		getAns();
		System.out.println("Ans="+ans);


	}//main

	static void getAns(){

		//Initial push to queue
		for(int i=0; i <m; i++)
			for(int j=0;j<n;j++){
				if(matrix[i][j]==2)
					q.add(new Cell(i,j,1));
				if(matrix[i][j]==1)
					one_count++;
			}

		if(one_count==0)
			return;
		else
		{
			while(!q.isEmpty() && one_count!=0){
				Cell cur = (Cell)q.remove();
				rotOthers(cur);
			}

			if(one_count!=0)
				ans=-1;
			
		}
				


	}

	static void rotOthers(Cell cur){
		
		int r=cur.row;
		int c=cur.col;
		int d=cur.depth;
		if(d>ans)
			ans++;


		if(r>0)
			if(matrix[r-1][c]==1){
				matrix[r-1][c]=2;
				one_count--;
				q.add(new Cell(r-1, c, d+1));	
			}
		if(r<(m-1))
			if(matrix[r+1][c]==1){
				matrix[r+1][c]=2;
				one_count--;
				q.add(new Cell(r+1, c, d+1));	
			}
		if(c>0)
			if(matrix[r][c-1]==1){
				matrix[r][c-1]=2;
				one_count--;
				q.add(new Cell(r, c-1,d+1));	
			}		
	
		if(r<(n-1))
			if(matrix[r][c+1]==1){
				matrix[r][c+1]=2;
				one_count--;
				q.add(new Cell(r, c+1, d+1));	
			}	
			
	}


}//end of class