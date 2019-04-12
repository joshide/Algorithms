package Revision2;

public class MaximumSumNoAdjacent {

	public static void main(String[] args) {
		int[] arr = {5,5,10,100,10,5};
		int maxSum = getMaximumSumNoAdjacent(arr);
		System.out.println(maxSum);

	}
	
	private static int getMaximumSumNoAdjacent(int[] arr) {
		int maxIncluding = arr[0];
		int maxExcluding = 0;
		
		for(int i = 1; i < arr.length; i++) {
			int temp = maxIncluding;
			maxIncluding = maxExcluding + arr[i];
			maxExcluding = Math.max(temp, maxExcluding);
		}
		
		return Math.max(maxIncluding, maxExcluding);
	}

}
