package Revision2;

public class MaximumSumContiguosSubArray {

	public static void main(String[] args) {
		int[] arr = {-2,-3,4,-1,-2,1,5,-3};
		
		int maxSum = getMaximumSum(arr);
		
		System.out.println(maxSum);

	}
	
	private static int getMaximumSum(int[] arr) {
		int maxEndingHere = 0;
		int maxSumSoFar = 0;
		
		for(int i = 0; i < arr.length; i++) {
			maxEndingHere = maxEndingHere + arr[i];
			
			maxSumSoFar = Math.max(maxSumSoFar, maxEndingHere);
			
			if(maxEndingHere < 0) {
				maxEndingHere = 0;
			}
		}
		
		return maxSumSoFar;
	}

}
