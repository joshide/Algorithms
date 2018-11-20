package geeksforgeeks.dynamic_programming;

public class CoinChange {

	private static int[][] store = null;
	public static void main(String[] args) {
		int n = 10;
		int[] arr = {2,5,3,6};
		
		store = new int[n+1][arr.length];
		
		int result = numberOfWaysToMakeChange(arr, n, 0);
		System.out.println(result);

	}
	
	private static int numberOfWaysToMakeChange(int[] arr, int n, int index) {
		if(n == 0) {
			return 1;
		}
			
		if(n < 0) {
			return 0;
		}
		
		if(index >= arr.length)
			return 0;
		
		if(store[n][index] != 0) {
			//System.out.println("result");
			return store[n][index];
		}
		
		int result1 = numberOfWaysToMakeChange(arr, n-arr[index], index);
		int result2 = numberOfWaysToMakeChange(arr, n, index+1);
		
		store[n][index] = result1+result2;
		
		return store[n][index];
		
	}

}
