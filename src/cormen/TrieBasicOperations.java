package cormen;

public class TrieBasicOperations {

	private static TrieNode root = new TrieNode();
	public static void main(String[] args) {
		
		String str1 = "abc";
		String str2 = "abcd";
		String str3 = "abgl";
		
		insertIntoTrie(str1);
		insertIntoTrie(str2);
		insertIntoTrie(str3);
		
		boolean result = isWordPresentInTrie("abcd");
		
		System.out.println(result);

	}
	
	private static boolean isWordPresentInTrie(String str) {
		
		TrieNode currentNode = root;
		
		for(int i = 0; i < str.length(); i++) {
			Character character = str.charAt(i);
			
			if(currentNode.map.get(character) == null) {
				return false;
			} else {
				currentNode = currentNode.map.get(character);
			}
		}
		
		if(currentNode.isLeafNode) {
			return true;
		} else {
			return false;
		}
		
	}
	
	private static void insertIntoTrie(String str) {
		
		TrieNode currentNode = root;
		for(int i = 0; i < str.length(); i++) {
			Character character = str.charAt(i);
			
			if(currentNode.map.get(character) == null) {
				TrieNode node = new TrieNode();
				currentNode.map.put(character, node);
				currentNode = node;
			} else {
				currentNode = currentNode.map.get(character);
			}
		}
		currentNode.isLeafNode = true;	
	}

}
