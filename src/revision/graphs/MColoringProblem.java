package revision.graphs;

import java.util.ArrayList;
import java.util.List;

public class MColoringProblem {

	private static int[] colorArr = null;
	public static void main(String[] args) {
		int[][] arr = {{0, 1, 1, 1}, 
		        {1, 0, 1, 0}, 
		        {1, 1, 0, 1}, 
		        {1, 0, 1, 0}, 
		    }; 
		
		int m = 3;
		
		colorArr = new int[arr.length];
		
		boolean result = isColoringPossible(arr, m, 0);
		System.out.println(result);
		
		for(int color : colorArr) {
			System.out.print(color + ",");
		}
		
		

	}
	
	private static boolean isColoringPossible(int[][] arr, int m, int vertex) {
		
		if(vertex == arr.length) {
			return true;
		}
		
		for(int i = 1; i <= m; i++) {
			boolean isSafe = isSafe(arr,vertex,i);
			
			if(isSafe) {
				colorArr[vertex] = i;
				
				boolean nextResult = isColoringPossible(arr, m, vertex+1);
				if(nextResult == true) {
					return true;
				} else {
					colorArr[vertex] = 0;
				}
			} 
		}
		return false;
	}
	
	private static boolean isSafe(int[][] arr, int vertex, int color) {
		Object[] adjacenetVertices = findAdjacentVertices(arr, vertex);
		
		for(int i = 0; i < adjacenetVertices.length; i++) {
			int av = (Integer) adjacenetVertices[i];
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
