package revision.graphs;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class TopologicalSort {

	private static List<GraphNode>[] adjacencyList = null;
	private static int time = 0;
	private static Stack<GraphNode> stack = new Stack<GraphNode>();
	public static void main(String[] args) {
		GraphNode n0 = new GraphNode(0);
		GraphNode n1 = new GraphNode(1);
		GraphNode n2 = new GraphNode(2);
		GraphNode n3 = new GraphNode(3);
		GraphNode n4 = new GraphNode(4);
		GraphNode n5 = new GraphNode(5);
		
		//Adjacency List Representation of Graph
		adjacencyList = new LinkedList[6];
		for(int i = 0; i < adjacencyList.length; i++) {
			adjacencyList[i] = new LinkedList<GraphNode>();
		}
		
		adjacencyList[0].add(n0);
		adjacencyList[1].add(n1); 
		adjacencyList[2].add(n2); adjacencyList[2].add(n3);
		adjacencyList[3].add(n3); adjacencyList[3].add(n1);
		adjacencyList[4].add(n4); adjacencyList[4].add(n0); adjacencyList[4].add(n1);
		adjacencyList[5].add(n5); adjacencyList[5].add(n0); adjacencyList[5].add(n2);
		
		for(int i = 0; i < adjacencyList.length; i++) {
			GraphNode firstNode = adjacencyList[i].get(0);
			if(firstNode.color.equals("white")) {
				depthFirstSearch(firstNode );
			}
		}
		
		while(!stack.isEmpty()) {
			GraphNode node = stack.pop();
			System.out.println(node.data + ":" + node.startTime + ":" + node.endTime);
		}

	}
	
	
	private static void depthFirstSearch(GraphNode node) {
		time = time + 1;
		node.startTime = time;
		node.color = "grey";
		
		LinkedList<GraphNode> ll = findLinkedList(node);
		
		for(int i = 1; i < ll.size(); i++) {
			GraphNode adjacentNode = ll.get(i);
			if(adjacentNode.color.equals("white")) {
				adjacentNode.parent = node;
				depthFirstSearch(adjacentNode);
			}
			
		}
		time = time + 1;
		node.endTime = time;
		node.color = "black";
		stack.push(node);
	}
	
	private static LinkedList<GraphNode> findLinkedList(GraphNode node) {
		for(int i = 0; i < adjacencyList.length; i++) {
			if(adjacencyList[i].get(0) == node) {
				return (LinkedList<GraphNode>) adjacencyList[i];
			}
		}
		return null;
	}

}
