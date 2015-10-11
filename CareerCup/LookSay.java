import java.util.ArrayList;
class LookSay{
	public static void main(String args[]){
		
		ArrayList<String> results = new ArrayList<String>();
		String current="1";
		int num_terms=10;	
		results.add(current);

		for(int i=0;i<num_terms;i++){
			char c[] = current.toCharArray();
			int j=0;
			char cur_char = c[0];
			int count=0;
			StringBuilder next = new StringBuilder();
			while(j<c.length){
				if(c[j]==cur_char){
					count++;
				}
				else
				{
					next.append(count);
					next.append(cur_char);
					cur_char=c[j];
					count=1;
				}
				j++;
			}
			next.append(count);
			next.append(cur_char);
			current = next.toString();
			results.add(current);

		}	

		for(String s: results)
			System.out.print(s+" ");

	}	//main
}