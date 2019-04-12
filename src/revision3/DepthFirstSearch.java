package revision3;

import java.util.ArrayList;
import java.util.List;

public class DepthFirstSearch {

	private static List<GraphNode>[] adjacenyList = null;
	private static int time = 1;
	public static void main(String[] args) {
		GraphNode n1 = new GraphNode(1);
		GraphNode n2 = new GraphNode(2);
		GraphNode n3 = new GraphNode(3);
		GraphNode n4 = new GraphNode(4);
		GraphNode n5 = new GraphNode(5);
		GraphNode n6 = new GraphNode(6);
		GraphNode n7 = new GraphNode(7);
		GraphNode n8 = new GraphNode(8);
		
		adjacenyList = new ArrayList[8];
		for(int i = 0; i < adjacenyList.length; i++) {
			adjacenyList[i] = new ArrayList<GraphNode>();
		}
		
		// Adjacency list representation of graph
		// O(V+E)
		adjacenyList[0].add(n1); adjacenyList[0].add(n2);
		adjacenyList[1].add(n2); adjacenyList[1].add(n3); adjacenyList[1].add(n4);
		adjacenyList[2].add(n3); adjacenyList[2].add(n7); adjacenyList[2].add(n8);
		adjacenyList[3].add(n4); adjacenyList[3].add(n5);
		adjacenyList[4].add(n5); adjacenyList[4].add(n6);
		adjacenyList[5].add(n6); adjacenyList[5].add(n4);
		adjacenyList[6].add(n7);
		adjacenyList[7].add(n8); adjacenyList[7].add(n7);
		
		for(int i = 0; i < adjacenyList.length; i++) {
			GraphNode node = adjacenyList[0].get(0);
			if(node.color.equals("white")) {
				depthFirstSearch(node);
			}		
		}
		

	}
	

	private static void depthFirstSearch(GraphNode node) {
		node.startTime = time;
		time = time + 1;
		node.color = "grey";
		System.out.print(node.data + ",");
		
		List<GraphNode> adjacentNodes = getChildNodes(node);
		for(int i = 1; i < adjacentNodes.size(); i++) {
			GraphNode adjacentNode = adjacentNodes.get(i);
			if(adjacentNode.color.equals("white")) {
				depthFirstSearch(adjacentNode);
			}
		}
		node.color = "black";
		node.endTime = time;
		time = time + 1;
	}
	
	private static List<GraphNode> getChildNodes(GraphNode node) {
		for(int i = 0; i < adjacenyList.length; i++) {
			if(adjacenyList[i].get(0) == node) {
				return adjacenyList[i];
			}
		}
		return null;
	}
	

}
