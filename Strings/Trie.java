import java.util.HashMap;
import java.util.ArrayList;

class TrieNode{
	HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();	
}

class Trie{
	private TrieNode root;
	private final char terminal = '$';
	private final int ALPHABET_SIZE = 26;
	Trie(){root = new TrieNode();}
	TrieNode getRoot(){return this.root;}	

	//Insert a trie node
	TrieNode insertNode(TrieNode parent, char c){
		TrieNode child = new TrieNode();
		if(parent.children.get(c)!=null)
			System.out.println("Cannot insert, child aleady exists.");
		else
			parent.children.put(c, child);
		return child;
	}
	
	
	//Inserting a string
	void insertString(String s){
		TrieNode current = root;
		for(int i=0;i<s.length();i++)
		{
			char c = s.charAt(i);
			if(current.children.get(c)!=null){
				current = (TrieNode)current.children.get(c);	
			}
			else{
				TrieNode newnode = insertNode(current, c);
				current = newnode;
			}
		}
		//Insert terminal character
		insertNode(current,terminal); 
	}

	boolean searchString(String s){
		TrieNode current = root;
		int len = s.length();
		for(int i=0;i<len;i++){
			char c = s.charAt(i);
			if(current.children.get(c)==null)
				return false;
			else
				current = (TrieNode)current.children.get(c);
		}
		if(current.children.get(terminal)!=null)
			return true;
		return false;
	}

	void deleteString(String s){
		int start_index=0;
		//Check if string contained in the trie
		if((s.length() < 1) || (root.children.get(s.charAt(start_index))==null))
			return;
		
		deleteHelper((TrieNode)root.children.get(s.charAt(0)), s, start_index+1);
	}

	boolean deleteHelper(TrieNode n, String s, int index){
		if(index==s.length())
			n.children.remove(terminal);
		else{
			char c = s.charAt(index);
			TrieNode child = n.children.get(c);
			//Recursive call to child
			boolean deleteChildLink = deleteHelper(child, s, index+1);
			if(deleteChildLink)	
				n.children.remove(c);
		}
		return !hasChildren(n);	
	}

	boolean hasChildren(TrieNode n){
		char c = 'a';
		for(int i=0;i<ALPHABET_SIZE;i++){
			if(n.children.get((char)(c+i))!=null)
				return true;			
		}
		return false;
	}
		

}//Trie

