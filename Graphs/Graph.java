import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;

class Graph{
	int n;
	int adj[][]=null;

	Graph(String filename){
		parseGraph(filename);
	}

	private void parseGraph(String filename){
		int count=0;
		int n;
		try{
			BufferedReader br = new BufferedReader(new FileReader(new File(filename)));
			String str = br.readLine();
			
			while(str!=null){
				if(count==0){
					n = Integer.parseInt(str)+1;
					adj = new int[n][n];
				}
				else{
					String split_string[] = str.split(" ");
					int from_node = Integer.parseInt(split_string[0]);
					int to_node = Integer.parseInt(split_string[1]);
					int weight = Integer.parseInt(split_string[2]);
					adj[from_node][to_node] = weight;
					adj[to_node][from_node] = weight;
				}
				count++;
				str = br.readLine();
			}
		}
		catch(IOException e){
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
	}
}