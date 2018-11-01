package geeksforgeeks.arrays;

public class LargestSumContiguousSubArray {

	public static void main(String[] args) {
		int[] arr = {-2,-3,4,-1,-2,1,5,-3};
		
		int maxSum = findMaximumSumOfContiguousArray(arr);
		
		System.out.println(maxSum);

	}
	
	private static int findMaximumSumOfContiguousArray(int[] arr) {
		int maxEndingHere = 0;
		int maxSoFar = 0;
		
		for(int i = 0; i < arr.length; i++) {
			maxEndingHere = maxEndingHere + arr[i];
			
			if(maxEndingHere > maxSoFar) {
				maxSoFar = maxEndingHere;
			}
			
			if(maxEndingHere < 0) {
				maxEndingHere = 0;
			}
		}
		
		return maxSoFar;
	}

}
