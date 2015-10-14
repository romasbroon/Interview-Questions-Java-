class SymmetricTree{
	public static void main(String args[]){
		BinaryTree tree = new BinaryTree();
		BinaryTreeNode n1 = new BinaryTreeNode(1);
		BinaryTreeNode n2 = new BinaryTreeNode(2);
		BinaryTreeNode n3 = new BinaryTreeNode(2);
		BinaryTreeNode n4 = new BinaryTreeNode(3);
		BinaryTreeNode n5 = new BinaryTreeNode(4);
		BinaryTreeNode n6 = new BinaryTreeNode(3);
		BinaryTreeNode n7 = new BinaryTreeNode(7);

		tree.insertAlter(n1, null);
		tree.insertAlter(n2, n1);
		tree.insertAlter(n3, n1);
		tree.insertAlter(n4, n2);
		tree.insertAlter(n5, n2);
		tree.insertAlter(n7, n3);
		tree.insertAlter(n6, n3);

		//tree.inOrder(tree.root);
		System.out.println("Answer: "+isSymmetric(tree));
	}


	public static boolean isSymmetric(BinaryTree tree){
		if(tree.root.left == null && tree.root.right==null)
			return true;
		return isSymmetricHelper(tree.root.left, tree.root.right);
	}

	public static boolean isSymmetricHelper(BinaryTreeNode n1, BinaryTreeNode n2){
		if(n1 == null && n2 == null)
			return true;
		else if(n1 == null || n2 == null)
			return false;
		else{
			if(n1.val != n2.val)
				return false;
			else
				return (isSymmetricHelper(n1.left, n2.right) && isSymmetricHelper(n1.right, n2.left));	
		} 		
	}
}