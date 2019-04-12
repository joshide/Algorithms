package Revision2;

public class TrieBasicOperations {

	private static TrieNode root = new TrieNode();
	public static void main(String[] args) {
		String str1 = "abc";
		String str2 = "abcd";
		String str3 = "abgl";
		
		insert(str1); insert(str2); insert(str3);

		System.out.println(isPresent("abgl"));
	}
	
	private static boolean isPresent(String str) {
		TrieNode currentNode = root;
		
		for(int i = 0; i < str.length(); i++) {
			char character = str.charAt(i);
			if(!currentNode.map.containsKey(character)) {
				return false;
			} else {
				currentNode = currentNode.map.get(character);
			}
		}
		return currentNode.leafNode;
	}
	
	private static void insert(String str) {
		TrieNode node = root;
		for(int i = 0; i < str.length(); i++) {
			char character = str.charAt(i);
			if(node.map.containsKey(character)) {
				node = node.map.get(character);
			} else {
				TrieNode child = new TrieNode();
				node.map.put(character, child);
				node = child;
			}
		}
		node.leafNode = true;
	}

}
