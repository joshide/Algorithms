package cormen;

// There are two ways to represents the graphs
// 1. Adjacency List : Space Complexity O(V+E)
// V represents number of vertices and E represents number of edges
// 2. Adjacency matrix : Space complexity O(V2).
// O(V+E) <= O(v2)
// AdjacencyList representation can be used when graph is sparse and AdjacencyMatrix can be used when graph is dense
// AdjacenyMatrix is useful when we need to determine fast if there is edge between two vertices
public class GraphNode {
	
	int data;
	String color;
	int distance;
	GraphNode parent;
	int start;
	int end;
	
	public GraphNode(int data) {
		this.data = data;
		color = "white";
		parent = null;
		distance = 0;			
	}

}
