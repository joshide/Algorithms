package revision.arrays;

public class MaximumSubIncreasingSubSequence {

	public static void main(String[] args) {
		int[] arr = {3, 4, 5, 10};
		
		int maxSum = findMaxSumOfIncreasingSubSequence(arr);
		System.out.println(maxSum);

	}
	
	private static int findMaxSumOfIncreasingSubSequence(int[] arr) {
		int[] maximumSum = new int[arr.length];
		
		for(int i = 0; i < arr.length; i++) {
			maximumSum[i] = arr[i];
		}
		
		for(int i = arr.length-1; i >= 0; i--) {
			int max = 0;
			for(int j = i+1; j < arr.length; j++) {
				if(arr[j] > arr[i]) {
					max = Math.max(max, maximumSum[j]);
				}
			}
			maximumSum[i] = maximumSum[i] + max;
		}
		
		int max = 0;
		for(int i = 0; i < maximumSum.length; i++) {
			max = Math.max(max, maximumSum[i]);
		}
		
		return max;
	}

}
