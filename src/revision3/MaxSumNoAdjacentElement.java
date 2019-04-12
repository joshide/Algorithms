package revision3;

public class MaxSumNoAdjacentElement {

	public static void main(String[] args) {
		int[] arr = {5,5,10,100,10,5};
		
		int maxSum = getMaxSum(arr);
		System.out.println(maxSum);
	}
	
	private static int getMaxSum(int[] arr) {
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
