package revision.graphs;

public class FindNumberOfIslands {

	public static void main(String[] args) {
		int[][] arr = {
				{1,1,0,0,0},
				{0,1,0,0,1},
				{1,0,0,1,1},
				{0,0,0,0,0},
				{1,0,1,0,1}
		};
		
		int numberOfIslands = findNumberOfIslands(arr);
		System.out.println(numberOfIslands);

	}
	
	private static int findNumberOfIslands(int[][] arr) {
		int count = 0;
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				if(arr[i][j] == 1) {
					count++;
					traverseAndNullify(arr, i, j);
				}
			}
		}
		
		return count;
	}
	
	private static void traverseAndNullify(int[][] arr, int i, int j) {
		
		if(i < 0 || i >= arr.length || j < 0 || j >= arr.length  || arr[i][j] == 0) {
			return;
		}
		arr[i][j] = 0;
		traverseAndNullify(arr, i, j-1);
		traverseAndNullify(arr, i, j+1);
		traverseAndNullify(arr, i-1, j);
		traverseAndNullify(arr, i+1, j);
		traverseAndNullify(arr, i-1, j-1);
		traverseAndNullify(arr, i-1, j+1);
		traverseAndNullify(arr, i+1, j-1);
		traverseAndNullify(arr, i+1, j+1);
	}

}
