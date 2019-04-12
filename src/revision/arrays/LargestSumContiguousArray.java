package revision.arrays;

public class LargestSumContiguousArray {

	public static void main(String[] args) {
		int[] arr = {-2,-3,4,-1,-2,1,5,-3};
		
		int maxSum = findLargestSum(arr);
		
		System.out.println("Maximum Sum in Contiguous Subarray : " + maxSum);

	}
	
	// Kandane's Algorithm
	private static int findLargestSum(int[] arr) {
		int maxSumSoFar = 0;
		int maxEndingHere = 0;
		
		for(int i = 0; i < arr.length; i++) {
			maxEndingHere = maxEndingHere + arr[i];
			
			if(maxEndingHere > maxSumSoFar) {
				maxSumSoFar = maxEndingHere;
			}
			
			if(maxEndingHere < 0) {
				maxEndingHere = 0;
			}
		}
		
		return maxSumSoFar;
	}

}
