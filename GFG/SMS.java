import java.util.HashMap;
import java.io.*;

class SMS{

	public static HashMap<Integer, String> map = new HashMap<Integer, String>();

	public static void main(String args[])throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		StringBuilder ans = new StringBuilder();
		
		initMap();
		int i=1;
		char cur_char=input.charAt(0);
		int cur_count=1;
		while(i<input.length()){
			char c = input.charAt(i);
			if(c==cur_char){
				cur_count++;
			}
			else{
				if(c=='#'){
					ans.append(appendChar(cur_char, cur_count));
					cur_char = input.charAt(i+1);
					cur_count=0;
				}
				else{
					ans.append(appendChar(cur_char, cur_count));
					cur_char = input.charAt(i);
					cur_count=1;
				}
			}
			i++;

		}
		ans.append(appendChar(cur_char, cur_count));
		
		System.out.println(ans.toString());

	}//main

	public static void initMap(){
		map.put(2, "ABC");
	}
	public static char appendChar(char cur_char, int cur_count){
		System.out.println("Cur char:"+cur_char);
		String map_str = (String)map.get((int)cur_char-48);
		return map_str.charAt((cur_count%map_str.length())-1);
	}


}