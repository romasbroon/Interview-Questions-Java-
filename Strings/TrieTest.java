class TrieTest{
	public static void main(String args[]){
		Trie trie = new Trie();
		trie.insertString("Aadarsh");
		trie.insertString("Aadab");
		System.out.println(trie.searchString("Aadab"));
		trie.deleteString("Aadab");
		System.out.println(trie.searchString("Aadab"));
		System.out.println(trie.searchString("Aadarsh"));
			
			
	}
}
