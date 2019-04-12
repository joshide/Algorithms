package revision.graphs;

public class GraphNode {

	int data;
	GraphNode parent;
	int distance;
	int startTime;
	int endTime;
	String color;
	
	GraphNode(int data) {
		this.data = data;
		color = "white";
	}
}
