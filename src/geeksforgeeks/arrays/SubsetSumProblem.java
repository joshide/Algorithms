package geeksforgeeks.arrays;

public class SubsetSumProblem {

	private static boolean[][] store = null;
	public static void main(String[] args) {
		int[] arr = {3,34,4,12,5,2};
		int sum = 9;
		store = new boolean[arr.length][sum+1];
		
		boolean bool = subsetSum(arr, 0, sum);
		System.out.println(bool);

	}
	
	private static boolean subsetSum(int[] arr, int index, int sum) {
		
		if(sum == 0)
			return true;
	
		
		if(sum < 0 || index >= arr.length)
			return false;
		
		if(store[index][sum] != false) {
			return store[index][sum];
		}
		
		boolean option1 = subsetSum(arr, index+1, sum - arr[index]);
		boolean option2 = subsetSum(arr, index+1, sum);
		
		store[index][sum] = option1 || option2;
		
		return store[index][sum];
	}

}
