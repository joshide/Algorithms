package geeksforgeeks.graphs;

public class TimeToRotAllOranges {

	private static int time  = 0;
	public static void main(String[] args) {
		
		// 0 empty cell
		// 1 : cell having fresh orange
		// 2 : cell having rotten orange
		int[][] arr = { {2, 1, 0, 2, 1},
                {0, 0, 1, 2, 1},
                {1, 0, 0, 2, 1}};
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[0].length; j++) {
				if(arr[i][j] == 2) {
					time = time + 1;
					rotAllAdjacentOranges(arr, i, j);
				}
			}
		}
		
		boolean result = true;
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[0].length; j++) {
				if(arr[i][j] == 1) {
					result = false;
				}
			}
		}
		
		System.out.println(result + " " + time);
		

	}
	
	private static void rotAllAdjacentOranges(int[][] arr, int i, int j) {
		if(i < 0 || i >= arr.length || j < 0 || j >= arr[0].length || arr[i][j] == 0 ) {
			return;
		}
		
		arr[i][j] = 0;
		rotAllAdjacentOranges(arr, i+1, j);
		rotAllAdjacentOranges(arr, i-1, j);
		rotAllAdjacentOranges(arr, i, j+1);
		rotAllAdjacentOranges(arr, i, j-1);
		
		
	}

}
