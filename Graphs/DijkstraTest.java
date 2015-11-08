import java.util.ArrayList;
public class DijkstraTest{
	public static void main(String args[]){
		Graph graph = new Graph("graph_input.txt");
		int ans[] = getMinDistances(1, graph);
		System.out.println("Min distances from 1 to other nodes are:");
		for(int i=2;i<ans.length;i++)
			System.out.println(i+" : "+ans[i]);
		System.out.println();
	}

	public static int[] getMinDistances(int source_node, Graph graph){
		int n = graph.adj.length-1;
		int dist[] = new int[n+1];
		for(int i=2;i<=n;i++){
			dist[i] = Integer.MAX_VALUE;
		}
		ArrayList<Integer> mstSet = new ArrayList<Integer>();
		mstSet.add(1);//add src node to mstSet
		int selected_node = 1;
		while(mstSet.size() != n){
			//System.out.println("here");
			//update key value for neighbors
			for(int i=1;i<=n;i++){
				if(i!=selected_node && graph.adj[selected_node][i]!=0){
					if(dist[selected_node]+graph.adj[selected_node][i] < dist[i]){
						//System.out.println("Updating min dist for: "+selected_node+" "+i);
						dist[i] = dist[selected_node]+graph.adj[selected_node][i];
					}
				}				
			}
			//Get next node with min dist to add to selected set
			int next_node = minDistNode(dist, mstSet);
			selected_node = next_node;
			//System.out.println("Next node: "+next_node+" Dist: "+dist[next_node]);
			
			mstSet.add(next_node);
		}

		return dist;
	}

	private static int minDistNode(int dist[], ArrayList<Integer> mstSet){
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