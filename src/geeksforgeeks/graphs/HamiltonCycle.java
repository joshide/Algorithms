package geeksforgeeks.graphs;

public class HamiltonCycle {

	private static int[] path = null;
	public static void main(String[] args) {
		
		int[][] graph = {{0, 1, 0, 1, 0}, 
                {1, 0, 1, 1, 1}, 
                {0, 1, 0, 0, 1}, 
                {1, 1, 0, 0, 1}, 
                {0, 1, 1, 1, 0}, 
               };
		
		path = new int[graph.length];
		
		for(int i = 0; i < path.length; i++) {
			path[i] = -1;
		}
		
		boolean result = checkIfHamlitonianCycleExists(graph,0);
		System.out.println(result);
		
		for(int n : path) {
			System.out.print(n + ",");
		}

	}
	
	private static boolean checkIfHamlitonianCycleExists(int[][] graph, int position) {
		
		if(position == graph.length) {
			int firstVertexInPath = path[0];
			int lastVertexInPath = path[position-1];
			
			if(graph[firstVertexInPath][lastVertexInPath] == 1)
				return true;
			else
				return false;
		}
		
		for(int i = 0; i < graph.length; i++) {
			
			boolean safe = isSafe(graph, i, position);
			
			if(safe) {
				path[position] = i;
				
				boolean result = checkIfHamlitonianCycleExists(graph, position+1);
				
				if(result == true) {
					return true;
				} else {
					path[position] = -1;
				}
			}	
		}
		return false;
	}
	
	private static boolean isSafe(int[][] graph, int vertex, int position) {
		
		for(int i = 0; i < path.length; i++) {
			if(path[i] == vertex) {
				return false;
			}
		}
		
		return true;
	}

}
