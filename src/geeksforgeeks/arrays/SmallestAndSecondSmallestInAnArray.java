package geeksforgeeks.arrays;

public class SmallestAndSecondSmallestInAnArray {

	private static int smallest = Integer.MAX_VALUE;
	private static int secondSmallest = Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		int[] arr = {12, 13, 1, 10, 34, 1};
		
		findSmallestAndSecondSmallest(arr);

	}
	
	private static void findSmallestAndSecondSmallest(int[] arr) {
		
		smallest = arr[0];
		secondSmallest = Integer.MAX_VALUE;
		
		for(int i = 1; i < arr.length; i++) {
			if(arr[i] < smallest) {
				secondSmallest = smallest;
				smallest = arr[i];
			}
		
			if(arr[i] > smallest && arr[i] < secondSmallest) {
				secondSmallest = arr[i];
			}
		}
		
		System.out.println("Smallest: " + smallest +" SecondSmallest: " + secondSmallest);
	}

}
