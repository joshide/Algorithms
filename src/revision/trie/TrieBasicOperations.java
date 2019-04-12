package revision.trie;

public class TrieBasicOperations {

	private static TrieNode root = new TrieNode();
	public static void main(String[] args) {
		String str1 = "abcd";
		String str2 = "abc";
		String str3 = "abgl";
		
		insert(str1); insert(str2); insert(str3);
		
		boolean result = isPresent("abgl");
		System.out.println(result);
		
		// For delete, just make the "isLeafNode" of leaf node to false

	}
	
	private static boolean isPresent(String str) {
		TrieNode currentNode = root;
		for(int i = 0; i < str.length(); i++) {
			Character character = str.charAt(i);
			if(!currentNode.map.containsKey(character)) {
				return false;
			} else {
				currentNode = currentNode.map.get(character);
			}
		}
		return currentNode.isLeafNode;
	}
	
	private static void insert(String str) {
		
		TrieNode currentNode = root;
		for(int i = 0; i < str.length(); i++) {
			Character charcter = str.charAt(i);
			if(currentNode.map.containsKey(charcter)) {
				currentNode = currentNode.map.get(charcter);
			} else {
				TrieNode node = new TrieNode();
				currentNode.map.put(charcter, node);
				currentNode = node;
			}
		}
		currentNode.isLeafNode = true;
	}

}
