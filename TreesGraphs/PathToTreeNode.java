class PathToTreeNode
{
	static String finalpath=null;
	public static void main(String args[])
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


		if(path(n[0],n[7],""))
			System.out.println(finalpath);

	}

	public static boolean path(Node src, Node dest, String path)
	{
		if(src==null)
			return false;
		if(src==dest)
		{
			path=path+" "+src.value;
			finalpath=path;
			return true;
		}

		for(Node n: src.children)
		{
			if(path(n,dest,path+" "+src.value))
				return true;
		}
		return false;

	}//end of path()
}