import java.util.List;
import java.util.ArrayList;

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
}

class PathSum{
	public static void main(String args[]){

	}

	public static List<List<Integer>> pathSum(TreeNode root, int sum){
		if(root!=null)
			return pathSumHelper(root, sum, 0);
		return null;
	}

	public static ArrayList<List<Integer>> pathSumHelper(TreeNode root, int sum, int parent_sum){
		ArrayList<List<Integer>> resultSet = null;
		if(!isLeaf(root)){
			ArrayList<List<Integer>> leftPaths = null;
			ArrayList<List<Integer>> rightPaths = null;
			if(root.left!=null)
				leftPaths = pathSumHelper(root.left, sum, parent_sum+root.val);
			if(root.right!=null)
				rightPaths = pathSumHelper(root.right, sum, parent_sum+root.val);
		
			if(leftPaths==null && rightPaths==null)
				return null;
			resultSet = new ArrayList<List<Integer>>();
			if(leftPaths!=null){
				for(List<Integer> list : leftPaths){
					list.add(0, root.val);
					resultSet.add(list);
				}
			}
			if(rightPaths!=null){
				for(List<Integer> list : rightPaths){
					list.add(0, root.val);
					resultSet.add(list);
				}
			}
		}
		else{
			if(parent_sum + root.val == sum){
				resultSet = new ArrayList<List<Integer>>();
				ArrayList<Integer> newList = new ArrayList<Integer>();
				newList.add(root.val);
				resultSet.add(newList);
			}
		}
		return resultSet;	
	}
	public static boolean isLeaf(TreeNode root){
	    if(root.left==null && root.right==null)
	        return true;
	    return false;
	}
}