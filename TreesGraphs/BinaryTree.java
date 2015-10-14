class BinaryTreeNode{
	int val;
	BinaryTreeNode left;
	BinaryTreeNode right;

	BinaryTreeNode(int val){this.val = val;}
}

class BinaryTree{
	BinaryTreeNode root;

	public void insertAlter(BinaryTreeNode child, BinaryTreeNode parent){
		if(parent == null){
			root = child;
			return;
		}
		if(parent.left == null)
			parent.left = child;
		else if(parent.right == null)
			parent.right = child;
	}


	public void insert(int childval, int parentval){
		
		if(parentval==-1 && root==null){
			root = new BinaryTreeNode(childval);
			return;
		}

		BinaryTreeNode parent = search(root, parentval);	
		BinaryTreeNode child = new BinaryTreeNode(childval);
		if(parent.left == null)
			parent.left = child;
		else if(parent.right == null)
			parent.right = child;
	}

	public BinaryTreeNode search(BinaryTreeNode n, int val){
		if(n.val == val)
			return n;

		BinaryTreeNode n1 = search(n.left, val);
		BinaryTreeNode n2 = search(n.right, val);
		if(n1 !=null || n2 != null)
			return n1!=null ? n1 : n2;
		return null;

	}

	public void inOrder(BinaryTreeNode n){
		if(n==null)
			return;
		inOrder(n.left);
		System.out.println(n.val+" ");
		inOrder(n.right);
	}

	public void preOrder(BinaryTreeNode n){
		if(n==null)
			return;		
		System.out.println(n.val+" ");
		inOrder(n.left);
		inOrder(n.right);
	}

	public void postOrder(BinaryTreeNode n){
		if(n==null)
			return;
		inOrder(n.left);		
		inOrder(n.right);
		System.out.println(n.val+" ");
	}



}