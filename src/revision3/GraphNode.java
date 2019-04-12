package revision3;

public class GraphNode {

	int data;
	String color;
	int distance;
	GraphNode parent;
	int startTime;
	int endTime;
	
	GraphNode(int data) {
		this.data = data;
		color = "white";
		distance = 0;
	}
}
