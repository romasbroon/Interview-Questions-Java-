import java.util.ArrayList;

class Node
{
	int value;
	ArrayList<Node> children;
	Node(int val)
	{
		this.value = val;
		children = new ArrayList<Node>();
	}
}
class Tree
{
	Node root;

	void addNode(Node current, Node parent)
	{
		if(parent==null)
		{
			root=current;
			return;
		}

		parent.children.add(current);
	}

	void getLists()
	{
		ArrayList<ArrayList<Node>> lists = new ArrayList<ArrayList<Node>>();
		preOrderTraversal(root, 1, lists);

		//Printing lists
		for(ArrayList<Node> l : lists)
		{

			for(Node n : l)
				System.out.print(n.value+ " ");
			System.out.println();
		}

	}

	void preOrderTraversal(Node n, int height, ArrayList<ArrayList<Node>> lists)
	{
		if(lists.size() < height)
			lists.add(new ArrayList<Node>());

		ArrayList<Node> temp = lists.get(height-1);
		temp.add(n);

		for(Node n1 : n.children)
		{
			if(n1!=null)
				preOrderTraversal(n1, height+1, lists);
		}
	}
}


class DepthLevelLists
{
	public static void main(String argsp[])
	{
		Tree t = new Tree();
		//Creating nodes
		Node n[] = new Node[8];

		for(int i=0;i<8;i++)
			n[i] = new Node(i+1);

		t.addNode(n[0],null);
		t.addNode(n[1],n[0]);
		t.addNode(n[2],n[0]);
		t.addNode(n[3],n[1]);
		t.addNode(n[4],n[1]);
		t.addNode(n[5],n[2]);
		t.addNode(n[6],n[2]);
		t.addNode(n[7],n[3]);

		//Getting list of nodes by level
		t.getLists();
	}

}