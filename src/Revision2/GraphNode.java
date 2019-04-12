package Revision2;

public class GraphNode {
	int data;
	GraphNode parent;
	String color;
	int distance;
	int startTime;
	int endTime;
	
	GraphNode(int data) {
		this.data = data;
		color = "white";
	}
	
}
