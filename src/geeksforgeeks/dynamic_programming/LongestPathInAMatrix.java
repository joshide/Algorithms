package geeksforgeeks.dynamic_programming;

public class LongestPathInAMatrix {

	private static int[][] store = null;
	public static void main(String[] args) {
		int[][] arr = {{1,2,9},{5,3,8},{4,6,7}};
		
		store = new int[arr.length][arr[0].length];
		
		int longestPath = getLongestPathInMatrix(arr);
		System.out.println(longestPath);

	}
	
	private static int getLongestPathInMatrix(int[][] arr) {
		
		int longestPath = 0;
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[0].length; j++) {
			longestPath = Math.max(longestPath,getLongestPathStartingFrom(arr,i,j,arr[i][j]-1));
				
			}
		}
		return longestPath;
		
	}
	
	private static int getLongestPathStartingFrom(int[][] arr, int i, int j, int value) {
		if(i < 0 || i >= arr.length || j < 0 || j >= arr[0].length) {
			return 0;
		}
		
		if(arr[i][j] - value != 1) {
			return 0;
		}
		if(store[i][j] != 0) {
			return store[i][j];
		}
		int path1 = 1 + getLongestPathStartingFrom(arr,i,j+1, arr[i][j]);
		int path2 = 1 + getLongestPathStartingFrom(arr,i+1,j, arr[i][j]);
		int path3 = 1 + getLongestPathStartingFrom(arr,i,j-1, arr[i][j]);
		int path4 = 1 + getLongestPathStartingFrom(arr,i-1,j, arr[i][j]);
		
		int maxPath1 = Math.max(path1, path2);
		int maxPath2 = Math.max(path3, path4);
		
		store[i][j] = Math.max(maxPath1, maxPath2);
		
		return store[i][j];
		
	}

}
