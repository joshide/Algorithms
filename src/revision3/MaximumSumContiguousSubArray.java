package revision3;

public class MaximumSumContiguousSubArray {

	public static void main(String[] args) {
		int[] arr = {-2,-3,4,-1,-2,1,5,-3};
		
		int maxSum = getMaximumSumContiguousSubArray(arr);
		
		System.out.println(maxSum);

	}
	
	private static int getMaximumSumContiguousSubArray(int[] arr) {
		int maxSumSoFar = 0;
		int maxEndingHere = 0;
		
		for(int i = 0; i < arr.length; i++) {
			maxEndingHere = maxEndingHere + arr[i];
			maxSumSoFar = Math.max(maxEndingHere, maxSumSoFar);
			if(maxEndingHere < 0) {
				maxEndingHere = 0;
			}
		}
		
		return maxSumSoFar;
	}

}
