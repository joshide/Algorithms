package geeksforgeeks.graphs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import cormen.GraphNode;

public class DetectCycleInAGraph {

	private static List<GraphNode>[] adjacencyList = null;
	private static Set<GraphNode> set = new HashSet<GraphNode>();
	public static void main(String[] args) {
		GraphNode n1 = new GraphNode(1);
		GraphNode n2 = new GraphNode(2);
		GraphNode n3 = new GraphNode(3);
		GraphNode n4 = new GraphNode(4);
		GraphNode n5 = new GraphNode(5);
		GraphNode n6 = new GraphNode(6);
		GraphNode n7 = new GraphNode(7);
		GraphNode n8 = new GraphNode(8);
		
		//Adjacency List Representation of Graph
		adjacencyList = new LinkedList[8];
		for(int i = 0; i < adjacencyList.length; i++) {
			adjacencyList[i] = new LinkedList<GraphNode>();
		}
		adjacencyList[0].add(n1); adjacencyList[0].add(n2);
		
		adjacencyList[1].add(n2); adjacencyList[1].add(n3); adjacencyList[1].add(n4);
		
		adjacencyList[2].add(n3); adjacencyList[2].add(n7); adjacencyList[2].add(n8);
		
		adjacencyList[3].add(n4); adjacencyList[3].add(n5);
		
		adjacencyList[4].add(n5); adjacencyList[4].add(n6);
		
		adjacencyList[5].add(n6); adjacencyList[5].add(n4);
		
		adjacencyList[6].add(n7); 
		
		adjacencyList[7].add(n8); adjacencyList[7].add(n7);
		
		for(int i = 0; i < adjacencyList.length; i++) {
			GraphNode node = adjacencyList[i].get(0);
			boolean result = isLoopPresentInGraph(node);
			if(result) {
				System.out.println("loop is present");
				return;
			}
		}
		System.out.println("loop is not present");

	}
	
	private static boolean isLoopPresentInGraph(GraphNode node) {
		
		set.add(node);
		
		LinkedList<GraphNode> ll = findLinkedList(node);
		boolean result = false;
		for(int i = 1; i < ll.size(); i++) {
			GraphNode adjacentNode = ll.get(i);
			if(set.contains(adjacentNode)) {
				result = true;
			} else {
				result = isLoopPresentInGraph(adjacentNode);
			}
		}
		set.remove(node);
		return result;
		
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
