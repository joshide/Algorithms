package cormen;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
	Map<Character,TrieNode> map;
	boolean isLeafNode;
	
	TrieNode() {
		map = new HashMap<Character,TrieNode>();
	}
	

}
