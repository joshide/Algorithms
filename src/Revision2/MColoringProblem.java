package Revision2;

import java.util.ArrayList;
import java.util.List;

public class MColoringProblem {

	private static int[] color = null;
	private static int c = 3;
	public static void main(String[] args) {
		int[][] arr = {{0, 1, 1, 1}, 
		        {1, 0, 1, 0}, 
		        {1, 1, 0, 1}, 
		        {1, 0, 1, 0}, 
		    }; 
		
		color = new int[arr.length];
		
		boolean result = isColorPossible(arr, 0);
		//System.out.print(result);
		
		for(int number : color) {
			System.out.print(number + ",");
		}

	}
	
	private static boolean isColorPossible(int[][] arr, int vertex) {
		if(vertex == arr.length) {
			return true;
		}
		
		for(int i = 1; i <= c; i++) {
			boolean isSafe = isSafe(arr,vertex, i);
			
			if(isSafe) {
				color[vertex] = i;
				boolean bool = isColorPossible(arr, vertex+1);
				if(bool == true) {
					return true;
				} else {
					color[vertex] = 0;
				}
			}
		}
		
		return false;
	}
	
	private static boolean isSafe(int[][] arr, int vertex, int c) {
		
		List<Integer> adjacentVertices = findAdjacentVertices(arr, vertex);
		
		for(int adjacentVertex : adjacentVertices) {
			if(color[adjacentVertex] == c) {
				return false;
			}
		}
		
		return true;
	}
	
	private static List<Integer> findAdjacentVertices(int[][] arr, int vertex) {
		List<Integer> arrList = new ArrayList<>();
		for(int i = 0; i < arr.length; i++) {
			if(arr[vertex][i] == 1) {
				arrList.add(i);
			}
		}
		
		return arrList;
	}

}
