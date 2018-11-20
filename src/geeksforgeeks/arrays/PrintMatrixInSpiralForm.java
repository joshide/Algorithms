package geeksforgeeks.arrays;

public class PrintMatrixInSpiralForm {

	public static void main(String[] args) {
		int[][] arr = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		
		printMatrixInSpiralForm(arr);

	}
	
	private static void printMatrixInSpiralForm(int[][] arr) {
		
		for(int i = 0; i < arr.length; i++ ) {
			if(i%2 == 0) { 
				// even rows
				printLeft(arr,i);
				System.out.println("");
			} else {
				printRight(arr,i);
				System.out.println("");
			}
				
		}
	}
	
	private static void printLeft(int[][] arr, int row) {
		for(int j = 0; j < arr.length; j++) {
			System.out.print(arr[row][j] + ",");
		}
	}
	
	private static void printRight(int[][] arr, int row) {
		for(int j = arr.length - 1; j >=0; j--) {
			System.out.print(arr[row][j] + ",");
		}
	}
	
	

}
