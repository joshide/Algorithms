package geeksforgeeks.dynamic_programming;

public class OptimalStrategyForGame {

	private static int[][] store = null;
	public static void main(String[] args) {
		
		int[] arr = {8,15,3,7};
		
		store = new int[arr.length][arr.length];
		
		int lowestPossibleMaximumValue = getMaximumValue(arr,0,arr.length-1);
		System.out.println(lowestPossibleMaximumValue);

	}
	
	private static int getMaximumValue(int[] arr, int start, int end) {
		if(start == end) {
			return arr[start];
		}
		
		if(start > end)
			return 0;
		
		if(store[start][end] != 0) {
			//System.out.println("result");
			return store[start][end];
		}
		
		int option1 = arr[start] + Math.min(getMaximumValue(arr, start+2, end), getMaximumValue(arr, start+1, end-1));
		int option2 = arr[end] + Math.min(getMaximumValue(arr, start, end-2), getMaximumValue(arr, start+1, end-1));	
		
		store[start][end] = Math.max(option1, option2);
		return store[start][end];
		
	}

}
