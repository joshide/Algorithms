package revision.graphs;

public class HamiltonCycle {

	private static int[] path;
	public static void main(String[] args) {
		// Hamiltonian path in an undirected graph is the path that visit all the vertices only once
		// if on this path first and last vertex are connected we call this hamiltonian cycle
		
		int[][] arr = {{0, 1, 0, 1, 0}, 
                {1, 0, 1, 1, 1}, 
                {0, 1, 0, 0, 1}, 
                {1, 1, 0, 0, 1}, 
                {0, 1, 1, 1, 0}, 
               };
		path = new int[arr.length];
		
		boolean result = isHamiltonianCyclePresent(arr,0);
		System.out.print(result);
		
		for(int number : path) {
			System.out.print(number + ",");
		}

	}
	
	private static boolean isHamiltonianCyclePresent(int[][] arr, int position) {
		
		if(position == arr.length) {
			int firstVertexInPath = path[0];
			int lastVertexInPath = path[position-1];
			
			if(arr[firstVertexInPath][lastVertexInPath] == 1)
				return true;
			else
				return false;
		}
		
		for(int vertex = 0; vertex < arr.length; vertex++) {
			boolean isSafe = isSafe(arr,vertex,position);
			if(isSafe) {
				path[position] = vertex;
				boolean result = isHamiltonianCyclePresent(arr, position+1);
				if(result == true) {
					return true;
				} else {
					path[position] = -1;
				}
			}
		}
		return false;
	}
	
	private static boolean isSafe(int[][] arr, int vertex, int position) {
		
		if(position != 0) {
			int previousPosition = position-1;
			int previousVertex = path[previousPosition];
			if(arr[previousVertex][vertex] == 0) {
				return false;
			}
		}
				
		for(int i = 0; i < position; i++) {
			if(path[i] == vertex) {
				return false;
			}
		}
		return true;
	}

}
