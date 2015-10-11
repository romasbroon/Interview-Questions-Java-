//Program to find longest prefix in a string which is also in a dictionary of given words

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Arrays;

class LongestPrefix{
	static final char TERMINAL = '$';
	static final int ALPHABET_SIZE = 26;

	public static void main(String args[])throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String text = br.readLine();
		String arr[] = {"are", "area", "base", "cat", "cater", "children", "basement"};
		ArrayList<String> dict = new ArrayList<String>(Arrays.asList(arr));		
		System.out.println("Longest prefix: "+getPrefix(text, dict));
	
	}
	static String getPrefix(String s, ArrayList<String> dict){
		StringBuilder ans = new StringBuilder();
		//Trie Construction
		Trie trie = new Trie();
		for(String str : dict)
			trie.insertString(str);
		TrieNode current = trie.getRoot();
		
		String prev = null;
		StringBuilder curr_prefix = new StringBuilder();
		for(int i = 0; i<s.length();i++){
			TrieNode child = (TrieNode)current.children.get(s.charAt(i));
			curr_prefix = curr_prefix.append(s.charAt(i));
			if(child==null)
				break;
			if(child.children.get(TERMINAL)!=null)
				prev = curr_prefix.toString();
			current = child;
		}		
		return prev;
			
	}
	boolean hasChildren(TrieNode n){
                for(int i=0;i<ALPHABET_SIZE;i++){
                        if(n.children.get((char)('a'+i))!=null)
                                return true;                    
                }
                return false;
        }

	
	
			

}
