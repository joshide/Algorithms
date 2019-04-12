package geeksforgeeks.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import cormen.GraphNode;

public class BreadthFirstSearch {

	private static List<GraphNode>[] adjacencyList = null;
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
		
		breadthFirstSearch(n1);

	}
	
	private static void breadthFirstSearch(GraphNode node) {
		
		
		Queue<GraphNode> queue = new LinkedList<GraphNode>();
		
		queue.add(node);
		node.color = "grey";
		
		while(!queue.isEmpty()) {
			GraphNode dequeuedNode = queue.poll();
			System.out.print(dequeuedNode.data + " ");
			
			LinkedList<GraphNode> ll = findLinkedList(dequeuedNode);
			for(int i = 1; i < ll.size(); i++) {
				GraphNode adjacentNode = ll.get(i);
				if(adjacentNode.color.equals("white")) {
					adjacentNode.distance = dequeuedNode.data;
					adjacentNode.parent = dequeuedNode;
					adjacentNode.color = "grey";
					queue.add(adjacentNode);
				}
			}
			dequeuedNode.color = "black";
			
		}	
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
