package geeksforgeeks.arrays;

public class MaximumSumSuchThatNoTwoElementsAreAdjacent {

	public static void main(String[] args) {
		int[] arr = {1,20,3};
		
		int nonAdjacentSum = findMaxNonAdjacentSum(arr);
		System.out.println(nonAdjacentSum);

	}
	
	private static int findMaxNonAdjacentSum(int[] arr) {
		int maxIncluding = 0;
		int maxExcluding = 0;
		
		for(int i = 0; i < arr.length; i++) {
			int tempMaxIncluding = maxIncluding;
			maxIncluding = arr[i] + maxExcluding;
			maxExcluding = Math.max(tempMaxIncluding, maxExcluding);	
		}
		
		return Math.max(maxIncluding, maxExcluding);
	}

}
