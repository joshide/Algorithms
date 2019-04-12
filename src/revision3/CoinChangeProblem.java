package revision3;

public class CoinChangeProblem {

	private static int[][] store = null;
	public static void main(String[] args) {
		int sum = 5;
		int[] arr = {1,2,3};
		
		store = new int[sum+1][arr.length];
		int ways = findWays(sum, arr,0);
		
		System.out.println(ways);

	}
	
	private static int findWays(int sum, int[] arr, int index) {
		if(index >= arr.length || sum < 0) {
			return 0;
		}
		if(sum == 0) {
			return 1;
		}
		
		if(store[sum][index] != 0) {
			System.out.println("result");
			return store[sum][index];
		}
		int option1 = findWays(sum - arr[index], arr, index);
		int option2 = findWays(sum, arr, index+1);
		
		store[sum][index] = option1+option2;
		return store[sum][index];
	}

}
