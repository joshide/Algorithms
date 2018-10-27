package coreman;

public class MaximumSubArray {

	public static void main(String[] args) {
		int[] arr = {13,-3,-25,20,-3,-16,-23,18,20,-7,12,-5,-22,15,-4,7};
		
		int maximumSum = findMaxSum(arr,0, arr.length-1);
		
		System.out.println("Maximum sum of the array is: " + maximumSum);

	}
	
	private static int findMaxSum(int[] arr, int start, int end) {
		if(start == end)
			return arr[start];
		
		int mid = (start+end)/2;
		int leftSum = findMaxSum(arr, start, mid);
		int rightSum = findMaxSum(arr, mid+1, end);
		int crossoverSum = findCrossoverSum(arr, start, mid, end);
		
		if(leftSum > rightSum && leftSum > crossoverSum) {
			return leftSum;
		} else if (rightSum > leftSum && rightSum > crossoverSum) {
			return rightSum;
		} else {
			return crossoverSum;
		}
		
	}
	
	private static int findCrossoverSum(int[] arr, int start, int mid, int end) {
		int leftSum = Integer.MIN_VALUE;
		int rightSum = Integer.MIN_VALUE;
		
		int sum = 0;
		
		for(int i = mid; i >= start; i--) {
			sum = sum + arr[i];
			if(sum > leftSum) {
				leftSum = sum;
			}
		}
		
		sum = 0;
		
		for(int i = mid+1; i <= end; i++) {
			sum = sum + arr[i];
			if(sum > rightSum) {
				rightSum = sum;
			}
		}
		
		return leftSum + rightSum;
	}

}
