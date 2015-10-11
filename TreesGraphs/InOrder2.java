class BNode{
	int value;
	BNode left, right;
	BNode(int val){this.value=val;}

}

class BTree{

	BNode root;
	int size=0;

	void addNode(BNode current, BNode parent)
	{
		this.size++;
		if(parent==null)
		{
			root=current;
			return;
		}

		//parent.left==null ? parent.left = current : parent.right = current;
		if(parent.left == null)
			parent.left = current;
		else
			parent.right=current;
	}
}

public class InOrder2{
	public static void main(String args[]){
		BTree t = new BTree();
		BNode one = new BNode(1);
		BNode two = new BNode(2);
		BNode three = new BNode(3);
		BNode four = new BNode(4);
		BNode five = new BNode(5);
		BNode six = new BNode(6);
		BNode seven = new BNode(7);


		t.addNode(one, null);
		t.addNode(two, one);
		t.addNode(three, two);
		t.addNode(four, three);
		//t.addNode(five, two);
		//t.addNode(six, five);
		//t.addNode(seven, three);


		inorder(t);
	}

	//In-order traversal without using stack or recursion
	public static void inorder(BTree t){
		BNode par[] = new BNode[t.size+1];
		boolean v[] = new boolean[t.size+1];
		BNode curr = t.root;

		while(curr!=null){
			if(curr.left!=null && !v[curr.value]){
				v[curr.value]=true;
				par[curr.left.value] = curr;
				curr = curr.left;
			}
			else{
				
				System.out.println(curr.value);
				if(curr.right == null){					
					curr = par[curr.value];	
				} //leaf
				else{
					par[curr.right.value] = par[curr.value];
					curr = curr.right;
				}
			}

		}
	}//inorder()


	public static void inorderrecurse(BNode n){
		if(n.left==null && n.right==null)
		{
			System.out.println(n.value);
			return;
		}	
		else{
			if(n.left!=null)
				inorderrecurse(n.left);
			System.out.println(n.value);
			if(n.right!=null)
				inorderrecurse(n.right);
		}
	}//inorderrecurse()
}