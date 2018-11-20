package geeksforgeeks.arrays;

public class MaximumSumIncreasingSubSequence {

	public static void main(String[] args) {
		int[] arr = {10,5,4,3};
		
		int sum = getMaximumSumIncreasingSubSequence(arr);
		
		System.out.println(sum);

	}
	
	private static int getMaximumSumIncreasingSubSequence(int[] arr) {
		int sum[] = new int[arr.length];
		for(int i = 0; i < arr.length; i++) {
			sum[i] = arr[i];
		}
		
		int sumValue = 0;
		int maxSum = 0;
		
		for(int i = arr.length - 2; i >=0; i--) {
			sumValue = 0;
			for(int j = i+1; j < arr.length; j++) {
				if(arr[j] > arr[i]) {
					sumValue = Math.max(sumValue, sum[j]);
				}
			}
			sum[i] = sum[i] + sumValue;
		}
		
		for(int value : sum) {
			maxSum = Math.max(maxSum, value);
		}
		
		return maxSum;
	}

}
