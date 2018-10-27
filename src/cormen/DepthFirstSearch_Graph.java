package cormen;

import java.util.ArrayList;
import java.util.List;

public class DepthFirstSearch_Graph {
	
	private static int time = 0;
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
		
		for(int i = 0; i < adjacenyList.length; i++) {
			GraphNode node = adjacenyList[0].get(0);
			if(node.color.equals("white")) {
				depthFirstSearch(adjacenyList, node);
			}
		}
	}
	
	private static void depthFirstSearch(List<GraphNode>[] adjacenyList, GraphNode node) {
		
		time = time + 1;
		node.color = "grey";
		node.start = time;
		System.out.print(node.data +",");
		List<GraphNode> adjacentNodes = findList(adjacenyList, node);
		for(int i = 1; i < adjacentNodes.size(); i++) {
			GraphNode adjacentNode = adjacentNodes.get(i);
			if(adjacentNode.color.equals("white")) {
				adjacentNode.parent = node;
				depthFirstSearch(adjacenyList, adjacentNode);
			}
			
		}
		node.color = "black";
		time = time + 1;
		node.end = time;
		
		
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
