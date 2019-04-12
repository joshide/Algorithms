package geeksforgeeks.graphs;

public class RatInAMaze {

	public static void main(String[] args) {
		int[][] arr = {
				{1,1,1,1},
				{1,1,1,1},
				{0,1,0,1},
				{1,1,1,1}
		};

		int result = findPathsToReachEnd(arr,0,0);
		
		System.out.println(result);
	}
	
	private static int findPathsToReachEnd(int[][] arr, int i, int j) {
		
		if(i == 3 && j == 3) {
			return 1;
		}
		
		if(j >= arr.length || i >= arr.length || arr[i][j] == 0 ) {
			return 0;
		}
		
		int path1 = findPathsToReachEnd(arr, i, j+1);
		int path2 = findPathsToReachEnd(arr, i+1, j);
		
		return path1 + path2;
		
	}

}
