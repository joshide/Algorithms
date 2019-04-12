package revision.dynamic_programming;

public class CoinChangeProblem {

	public static void main(String[] args) {
		int sum = 10;
		int[] arr = {2,5,3,6};
		
		int ways = findWays(arr,sum,0);
		
		System.out.println(ways);

	}
	
	private static int findWays(int[] arr, int sum, int index) {
		
		if(index >= arr.length || sum < 0) {
			return 0;
		}
		
		if(sum == 0) {
			return 1;
		}
		
		int option1 = findWays(arr, sum-arr[index], index);
		int option2 = findWays(arr, sum, index+1);
		
		return option1 + option2;
		
	}

}
