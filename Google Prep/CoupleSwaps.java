class SwapPos{
	int left_index, right_index;
	SwapPos(){
		left_index=-1;
		right_index=-1;
}
}

class CoupleSwaps{

public static void main(String args[]){

//Take input
String str = "ACABCDDB";
char s[] = str.toCharArray();
System.out.println("Min swaps: "+minSwaps(s));
}//main

public static int minSwaps(char[] s){
	int total=0;
	int n = s.length;
	for(int i=0 ; i<s.length;i++){
		if((i>0 && s[i]==s[i-1]) || (i<(n-1) && s[i]==s[i+1]))
			continue;
		SwapPos swaps = swapPositions(s, i);
		int m1=-1, m2=-1;
		if(swaps.left_index!=-1)
			{
				swap(s,swaps.left_index,i);
			m1 = correctSeatings(s);
			swap(s,swaps.left_index, i);
		}
		if(swaps.right_index!=-1)
			{
				swap(s,swaps.right_index,i);
			m2 = correctSeatings(s);
			swap(s,swaps.right_index, i);
		}

		int final_swap_index = m1>m2 ? swaps.left_index : swaps.right_index;
		if(final_swap_index!=-1){
			System.out.println("swapping "+i+" and "+final_swap_index);	
			total++;
		swap(s, final_swap_index, i);		
		}
		
	}	
	return total;
}//minSwaps()


public static void swap(char s[], int l, int r){
    	char temp = s[l];
    	s[l] = s[r];
    	s[r] = temp;
 }


public static SwapPos swapPositions(char s[], int index){
	SwapPos pos = new SwapPos();
	int n = s.length;
	for(int i=0;i<n;i++)
		{
			if(i!=index)
			{
				if(s[i]==s[index]){
					if((i-1)>=0)
						pos.left_index=i-1;
					if((i+1)<n)
						pos.right_index=i+1;					
				}
			}
		}
	return pos;
}

public static int correctSeatings(char s[]){
	int count=0;
	int n = s.length;
	for(int i=0;i<s.length;i++){
		if(i!=0 && i!=(n-1)){
			if(s[i]==s[i-1] || s[i]==s[i+1])
				count++;
		}
		else{
			if(i==0)
				if(s[i]==s[i+1])
					count++;
			if(i==(n-1))
				if(s[i]==s[i-1])
					count++;
		}
	}
	return count;
}//correctSeatings()

}//class
