
import java.util.ArrayList;

class Prims implements MinimumSpanningTree{
	public void getMST(int adj[][]){
		//Num of nodes
		int n = adj.length-1;
		int parent[] = new int[n+1];
		int dist[] = new int[n+1];
		for(int i=2;i<=n;i++){
			dist[i] = Integer.MAX_VALUE;
		}
		ArrayList<String> mst_edges = new ArrayList<String>();
		ArrayList<Integer> mstSet = new ArrayList<Integer>();
		mstSet.add(1);//add src node to mstSet
		parent[1]=-1;//src node
		int selected_node = 1;
		while(mstSet.size() != n){
			//System.out.println("here");
			//update key value for neighbors
			for(int i=1;i<=n;i++){
				if(i!=selected_node && adj[selected_node][i]!=0){
					if(adj[selected_node][i] < dist[i]){
						//System.out.println("Updating min dist for: "+selected_node+" "+i);
						dist[i] = adj[selected_node][i];
						parent[i] = selected_node;
					}
				}
				
			}
			//Get next node with min dist to add to selected set
			int next_node = minDistNode(dist, mstSet);
			selected_node = next_node;
			//System.out.println("Next node: "+next_node);
			
			mstSet.add(next_node);
			mst_edges.add("Adding edge "+parent[next_node]+"-"+next_node+" : weight="+adj[parent[next_node]][next_node]);
		}

		for(String s: mst_edges)
			System.out.println(s);

	}//getMST();

	private int minDistNode(int dist[], ArrayList<Integer> mstSet){
		int min = Integer.MAX_VALUE;
		int min_node=0;
		int n = dist.length-1;
		for(int i=1;i<=n;i++){
			if(dist[i] < min && !mstSet.contains(i)){
				min=dist[i];
				min_node = i;
			}
		}
		return min_node;
	}
}
public class PrimsTest{
	public static void main(String args[]){
		//Parse Graph from file
		Graph graph = new Graph("graph_input.txt");
		Prims prims_obj = new Prims();
		prims_obj.getMST(graph.adj);
	}	
}

