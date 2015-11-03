class AddWordSearch{
	public static void main(String args[]){
		Trie trie = new Trie();
		trie.addWord("a");
		trie.addWord("a");
		String arr[] = { "a."};
		for(String s: arr)
			System.out.print(trie.search(trie.root, s)+" ");
		System.out.println();
	}
}