package geeksforgeeks.arrays;

public class MaxDiffBetweenTwoElementsLargerAppearAfterSmaller {

	public static void main(String[] args) {
		int[] arr = {7, 9, 5, 6, 3, 2};
		
		int maxDiff = findMaxDiff(arr);
		
		System.out.println(maxDiff);

	}
	
	private static int findMaxDiff(int[] arr) {
		int minimum = arr[0];
		int maxDiff = Integer.MIN_VALUE;
		
		for(int i = 1; i < arr.length; i++) {
			if(arr[i] > minimum) {
				maxDiff = Math.max(maxDiff, arr[i] - minimum);
			} else {
				minimum = arr[i];
			}
		}
		
		return maxDiff;
	}

}
