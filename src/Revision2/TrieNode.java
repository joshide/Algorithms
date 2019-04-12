package Revision2;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {

	boolean leafNode;
	Map<Character,TrieNode> map;
	
	TrieNode() {
		leafNode = false;
		map = new HashMap<>();
	}
}
