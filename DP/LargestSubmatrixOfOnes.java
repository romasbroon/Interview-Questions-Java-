import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;

class LargestSubmatrixOfOnes{
	public static void main(String args[]){
		int x[][] = null;
		int m=0,n=0;
		try{
			BufferedReader br = new BufferedReader(new FileReader(new File("matrix.txt")));
			String s[] = br.readLine().split(" ");
			m=Integer.parseInt(s[0]);
			n=Integer.parseInt(s[1]);
			x = new int[m][n];
			for(int i=0;i<m;i++){
				s = br.readLine().split(" ");
				for(int j=0;j<n;j++){
					x[i][j] = Integer.parseInt(s[j]);
				}
			}	
		}
		catch(IOException e){
			e.getMessage();
			e.printStackTrace();
		}	

		System.out.println("Longest submatrix size: "+largestSubmatrix(x, m, n));
	}

	public static int largestSubmatrix(int x[][], int m, int n){
		int ans=0;
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				int maxsquare = Math.min(m-i, n-j); //Max size of square matrix possible for the cell starting at i,j
				boolean prev = false; //Does prev square submatrix of smaller size have all 1's
				for(int k=1; k<=maxsquare; k++){

					int rs=i, re=rs+k-1;
					int cs=j, ce=cs+k-1;
					
					if(rs==re && cs==ce){
						if(x[rs][cs]==1)
							prev=true;
					}
					else{
						if(!prev)
							break;
						boolean flag=true; //True as long as last row and last col contain all 1s
						for(int l=0; l<k && flag; l++){
							//System.out.println("here");
							if(x[rs+l][ce]==0)
								flag=false;
							if(x[re][cs+l]==0)
								flag=false;
						}
						
						prev = flag;
					}
					if(prev && k > ans)
						ans=k;
				}//loop for submatrix size
			}
		}
		return ans;
	}//largestSubmatrix()	
}