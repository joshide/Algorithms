package geeksforgeeks.graphs;

import java.util.ArrayList;
import java.util.List;

public class MColoringProblem {

	private static int[] colorArr = null;
	public static void main(String[] args) {
		int[][] graph = {{0, 1, 1, 1}, 
		        {1, 0, 1, 0}, 
		        {1, 1, 0, 1}, 
		        {1, 0, 1, 0}, 
		    };
		
		int m = 3;
		
		colorArr = new int[graph.length];
		
		boolean result = color(graph,0,m);
		
		System.out.println(result);
		
		for(int color : colorArr) {
			System.out.print(color + ",");
		}


	}
	
	private static boolean color(int[][] graph, int vertex, int m) {
		
		if(vertex == graph.length) {
			return true;
		}
		
		for(int i = 1; i <=m ; i++) {
			boolean safe = isSafe(graph,vertex,i);
			if(safe) {
				colorArr[vertex] = i;
				
				boolean result = color(graph, vertex+1, m);
				if(result == true) {
					return true;
				} else {
					colorArr[vertex] = 0;
				}
			}
		}
		
		return false;
	}
	
	private static boolean isSafe(int[][] graph, int vertex, int color) {
		
		Object[] adjacentVertices = findAdjacentVertices(graph,vertex);
		
		
		for(int i = 0; i < adjacentVertices.length; i++) {
			int av = (Integer)adjacentVertices[i];
			if(colorArr[av] == color) {
				return false;
			}
		}
		return true;
	}
	
	private static Object[] findAdjacentVertices(int[][] graph, int vertex) {
		int[] columns = graph[vertex];
		
		List<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i < columns.length; i++) {
			if(columns[i] == 1) {
				list.add(i);
			}
		}
		
		return list.toArray();
	}

}
