package revision.arrays;

public class MaximumSumNoTwoElementsAreAdjacent {

	public static void main(String[] args) {
		int[] arr = {1, 2, 3};
		
		int maxSum = findMaximumSumNoTwoElementsAdjacent(arr);
		System.out.println(maxSum);

	}
	
	private static int findMaximumSumNoTwoElementsAdjacent(int[] arr) {
		int maxIncluding = arr[0];
		int maxExcluding = 0;
		
		for(int i = 1; i < arr.length; i++) {
			int temp = maxIncluding;
			maxIncluding = maxExcluding + arr[i];
			maxExcluding = Math.max(maxExcluding, temp);
		}
		
		return Math.max(maxIncluding, maxExcluding);
	}

}
