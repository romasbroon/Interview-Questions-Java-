class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int val){
		this.val=val;
		left=null;
		right=null;
	}
}
class Tree{
	TreeNode root;

	TreeNode insert(int val){
		TreeNode newnode = new TreeNode(val);
		if(root==null)
			root = newnode;
		return newnode;
	}
}

class BST{
	TreeNode root;

	public TreeNode insert(int val){
		TreeNode newnode = new TreeNode(val);
		//Find place of insertion
		TreeNode start = root;
		TreeNode prev = null;
		while(start!=null){
			prev = start;
			if(val <= start.val)
				start = start.left;
			else
				start = start.right;
		}
		if(val <= prev.start)
			prev.left = newnode;
		else
			prev.right = newnode;

	}

	//Search a node with value val
	public TreeNode search(int val){
		TreeNode start = root;
		
		while(start!=null){
			if(start.val == val)
				return start;
			else if(val < start.val)
				start = start.left;
			else
				start = start.right; 
		}
		if(start==null)
			System.out.println("Node not found.");
		return start;
	}

}