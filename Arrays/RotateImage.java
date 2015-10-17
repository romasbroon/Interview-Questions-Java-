class RotateImage
{
	public static void main(String args[]){

		int m[][] = new int[5][7];
		int n = m.length;
		int k = m[0].length; 

		int ctr=0;
		for(int i=0;i<n;i++){
			for(int j=0;j<k;j++){
				m[i][j] = ctr%10;
				ctr++;
			}
		}

		int output[][] = rotatePictureMethod(m, 1);
		print(m);
		System.out.println("\n\n");
		print(output);


	}
	public static void print(int m[][]){
		int n = m.length;
		int k = m[0].length;

		for(int i=0;i<n;i++){
			for(int j=0;j<k;j++){
				System.out.print(m[i][j]+" ");
			}
			System.out.println();
		}
			
	}


	public static int[][] rotatePictureMethod(int [][]matrix, int flag){
		if(flag==1)
			return rotatePictureMethodHelper(matrix);
		else{
			int temp[][] = matrix;
			int newm[][] = null;
			for(int i=0;i<3;i++){
				newm = rotatePictureMethodHelper(temp);
				temp = newm;
			}
			return newm;
		}

	}

	public static int[][]  rotatePictureMethodHelper(int[][] matrix)
	{
	    
	    // INSERT YOUR CODE HERE
	    int n = matrix.length;
	    int m = matrix[0].length;

	    int o[][] = new int[m][n];

	    //Initializing variables
	    int rs = 0, re = n-1, cs = 0, ce = m-1;
	    int rso = 0, reo = m-1, cso=0, ceo = n-1;

	    while(rs<=re || cs<=ce){
	    	if(cs<=ce){
			    int n1 = ce - cs + 1;
			    for(int i=0;i<n1;i++){
			    	o[rso+i][ceo] = matrix[rs][cs+i];
			    	o[reo-i][cso] = matrix[re][ce-i];
			    }
			}
			if(rs<=re){
			    int n2 = re - rs + 1;
			    for(int i=0;i<n2;i++){
			    	o[reo][ceo-i] = matrix[rs+i][ce];
			    	o[rso][cso+i] = matrix[re-i][cs];
			    }
			}
	        rs++;rso++;
	        re--;reo--;
	        cs++;cso++;
	        ce--;ceo--;
	    }
	    return o;    
  	}
}