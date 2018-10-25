package sorting;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// BreadthFirst Search uses three colors : White, Grey and Black
// White represents that the vertex is not being visited
// Grey represents that vertex is visited
// Black represents that vertex is visited and also all of its adjacent vertices too.
// Breadth first search can give us the shortest path between source and given vertex
// using parent information we can also print source to given vertex path
// if we consider initializing the vertices in BFS, the complexity is O(V+E)

public class BreadthFirstSearch_Graph {

	public static void main(String[] args) {
		
		GraphNode n0 = new GraphNode(0);
		GraphNode n1 = new GraphNode(1);
		GraphNode n2 = new GraphNode(2);
		GraphNode n3 = new GraphNode(3);
		GraphNode n4 = new GraphNode(4);
		GraphNode n5 = new GraphNode(5);
		GraphNode n6 = new GraphNode(6);
		
		
		List<GraphNode>[] adjacenyList = new ArrayList[7];
		
		List<GraphNode> list0 = new ArrayList<>();
		list0.add(n0); list0.add(n1); list0.add(n2);
		
		List<GraphNode> list1 = new ArrayList<>();
		list1.add(n1); list1.add(n3); list1.add(n4);
		
		List<GraphNode> list2 = new ArrayList<>();
		list2.add(n2); list2.add(n5); list2.add(n6);
		
		List<GraphNode> list3 = new ArrayList<>();
		list3.add(n3); list3.add(n4);
		
		List<GraphNode> list4 = new ArrayList<>();
		list4.add(n4);
		
		List<GraphNode> list5 = new ArrayList<>();
		list5.add(n5);
		
		List<GraphNode> list6 = new ArrayList<>();
		list6.add(n6);
		
		adjacenyList[0] = list0;
		adjacenyList[1] = list1;
		adjacenyList[2] = list2;
		adjacenyList[3] = list3;
		adjacenyList[4] = list4;
		adjacenyList[5] = list5;
		adjacenyList[6] = list6;
		
		breadthFirstSearch(adjacenyList,n0);
		
		System.out.println("\nDistance of node 4 from node 0 " + n4.distance);
		
		printPath(n4);
		
		
				
	}
	
	private static void printPath(GraphNode node) {
		if(node == null) {
			return;
		}
		printPath(node.parent);
		System.out.print(node.data +",");
	}
	
	// Complexity is (E) if we don't have to make the initializing call to make the color of every
	// node "white" since this is done while instantiating the nodes.
	private static void breadthFirstSearch(List<GraphNode>[] adjacenyList, GraphNode startNode) {
		
		Queue<GraphNode> queue = new LinkedList<>();
		startNode.color ="grey";
		queue.add(startNode);
		System.out.print(startNode.data +",");
		
		// complexity is E
		while(!queue.isEmpty()) {
			GraphNode node = queue.remove();
			List<GraphNode> nodeList = findList(adjacenyList, node); // ignore this call for complexity
			for(int i = 1; i < nodeList.size(); i++) {
				GraphNode adjacentNode = nodeList.get(i);
				if(adjacentNode.color.equals("white")) {
					adjacentNode.color = "grey";
					adjacentNode.parent = node;
					adjacentNode.distance = node.distance + 1;
					System.out.print(adjacentNode.data + ",");
					queue.add(adjacentNode);
				}	
			}
			node.color = "black";			
		}
	}
	
	private static List<GraphNode> findList(List<GraphNode>[] adjacenyList, GraphNode node) {
		for(List<GraphNode> list : adjacenyList) {
			if(list.get(0) == node) {
				return list;
			}
		}
		return null;
	}

}
