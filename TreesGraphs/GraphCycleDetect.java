import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.HashSet;

class Graph{
	int size;
	int adj[][];
	Graph(int size, String inputFile)throws IOException{
		this.size = size;
		adj = new int[size][size];
		File f = new File(inputFile);
		BufferedReader br = new BufferedReader(new  FileReader(f));
		String  s = br.readLine();
		while(s!=null){
			String str[] = s.split(" ");
			adj[Integer.parseInt(str[0])][Integer.parseInt(str[1])] = 1;
			s = br.readLine();
		}
	}
}

class GraphCycleDetect{
	
	static boolean vis[];
	
	public static void main(String args[])throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter no of nodes: ");
		int n = Integer.parseInt(br.readLine());
		vis = new boolean[n];
		System.out.println("Enter a file name: ");
		String fileName = br.readLine();
		Graph g = new Graph(n, fileName);
		boolean ans = cycleExists(g);
		if(ans)
			System.out.println("There is a cycle in graph");
		else
			System.out.println("No cycle in graph.");
	}//main


	public static boolean cycleExists(Graph g){
		HashSet<Integer> hs = new HashSet<Integer>();
		if(dfs(g, 0, hs))
			return true;
		else{
			boolean ans = false;
			for(int i=0;i<g.size;i++){
				if(vis[i]==false)
					ans |= dfs(g, i, hs);		
			}
			return ans;
		}
	}

	public static boolean dfs(Graph g, int v, HashSet<Integer> parent_nodes){
		vis[v] = true;
		boolean ans = false;
		int n = g.size;
		parent_nodes.add(v);
		for(int i=0;i<n;i++){
			if(g.adj[v][i]==1){
			if(parent_nodes.contains(i))
				return true;
			else 	
				ans |= dfs(g, i, parent_nodes);
	 
			}		
		}
		parent_nodes.remove(v);
		return ans;
	}//dfs

}
