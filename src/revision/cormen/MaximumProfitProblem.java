package revision.cormen;

public class MaximumProfitProblem {

	public static void main(String[] args) {
		int[] arr = {13,-3,-25,20,-3,-16,-23,18,20,-7,12,-5,-22,15,-4,7};
		
		int maximumSumContiguousSubArray = findMaximumSum(arr,0,arr.length-1);
		
		System.out.println(maximumSumContiguousSubArray);

	}
	
	private static int findMaximumSum(int[] arr, int start, int end) {
		if(start == end) {
			return arr[start];
		}
		
		int mid = (start + end)/2;
		
		int leftSum = findMaximumSum(arr, start, mid);
		int rightSum = findMaximumSum(arr, mid+1, end);
		int crossOverSum = findCrossOverSum(arr, start, mid, end);
		
		if(leftSum >= rightSum && leftSum >= crossOverSum) {
			return leftSum;
		} else if (rightSum >= leftSum && rightSum >= crossOverSum) {
			return rightSum;
		} else {
			return crossOverSum;
		}
	}
	
	private static int findCrossOverSum(int[]arr, int start, int mid, int end) {
		int leftSum = arr[mid];
		int sum = arr[mid];
		int rightSum = arr[mid+1];
		
		for(int i = mid-1; i >= 0; i--) {
			sum = sum + arr[i];
			if(sum > leftSum) {
				leftSum = sum;
			}
		}
		
		sum = arr[mid+1];
		
		for(int i = mid+2; i <= end; i++) {
			sum = sum + arr[i];
			if(sum > rightSum) {
				rightSum = sum;
			}
		}
		
		return leftSum + rightSum;
	}

}
