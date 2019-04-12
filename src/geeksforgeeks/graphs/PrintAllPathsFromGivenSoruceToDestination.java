package geeksforgeeks.graphs;

import java.util.LinkedList;
import java.util.List;

import cormen.GraphNode;

public class PrintAllPathsFromGivenSoruceToDestination {

	private static List<GraphNode>[] adjacencyList = null;
	public static void main(String[] args) {
		GraphNode n0 = new GraphNode(0);
		GraphNode n1 = new GraphNode(1);
		GraphNode n2 = new GraphNode(2);
		GraphNode n3 = new GraphNode(3);
		
		//Adjacency List Representation of Graph
		adjacencyList = new LinkedList[4];
		for(int i = 0; i < adjacencyList.length; i++) {
			adjacencyList[i] = new LinkedList<GraphNode>();
		}
		
		adjacencyList[0].add(n0); adjacencyList[0].add(n1); adjacencyList[0].add(n2); adjacencyList[0].add(n3);
		adjacencyList[1].add(n1); adjacencyList[1].add(n3);
		adjacencyList[2].add(n2); adjacencyList[2].add(n0); adjacencyList[2].add(n1);
		adjacencyList[3].add(n3);
		
		printPath(n2,n3,"");

	}
	
	private static void printPath(GraphNode n1, GraphNode n2, String path) {
		
		if(n1 == n2) {
			System.out.println(path + "," + n2.data);
			return;
		}
		n1.color = "grey";
		LinkedList ll = findLinkedList(n1);
		for(int i = 1; i < ll.size(); i++) {
			GraphNode node = (GraphNode) ll.get(i);
			if(node.color.equals("white")) {
			printPath(node, n2, path + "," + n1.data);
		 }
		}
		n1.color = "white";	
		
		
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
