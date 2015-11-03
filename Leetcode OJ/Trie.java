import java.util.HashMap;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.Map;
import java.util.Iterator;
import java.util.List;

class TrieNode{
	char val;
	boolean isLeaf;
	HashMap<Character, TrieNode> children = null;
	TrieNode(char c){
		this.val=c;
		children = new HashMap<Character, TrieNode>();
	}
}

public class Trie{
	TrieNode root = new TrieNode('\0');


	public void addWord(String str){
		TrieNode parent = root;
		int n = str.length();
		for(int i=0;i<n;i++){
			char c = str.charAt(i);
			TrieNode child = null;
			if(parent.children.get(c) == null){
				child = new TrieNode(c);
				parent.children.put(c, child);
				
			}
			else{
				child = (TrieNode)parent.children.get(c);
			}
			parent = child;
			if(i==n-1)
					child.isLeaf=true;
		}
	}//addWord()

	public boolean search(TrieNode root, String word){
		//System.out.println(root);

		TrieNode parent = root;
		int n = word.length();
		TrieNode child = null;
		for(int i=0;i<n;i++){			
			char c = word.charAt(i);
			if(c != '.'){
				System.out.println("current char: "+c);
				if(parent.children.get(c) == null)
					return false;
				else{
					child = parent.children.get(c);
					parent = child;
				}
			}
			else{
				
				Iterator it = parent.children.entrySet().iterator();
			    List<TrieNode> multiple_children = new ArrayList<TrieNode>();
			    while (it.hasNext()) {
			        Map.Entry pair = (Map.Entry)it.next();
			        multiple_children.add((TrieNode)pair.getValue());
			        //it.remove(); // avoids a ConcurrentModificationException
			    }
			    boolean ans = false;
			    for(TrieNode tn : multiple_children){
			    	ans |= search(tn, word.substring(i+1));
			    	if(ans)
			    		return true;
			    }
			    if(multiple_children.size()!=0 && i==n-1)
			    	return true;
			    return false;
			}
		}
		if(child!=null)
			return child.isLeaf;
		return false;
	}//search()
}