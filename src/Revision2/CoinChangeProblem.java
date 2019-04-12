package Revision2;

public class CoinChangeProblem {

	public static void main(String[] args) {
		int sum = 10;
		int[] arr = {2,5,3,6};
		
		int totalWays = findTotalWays(sum,arr,0);
		
		System.out.println(totalWays);

	}
	
	private static int findTotalWays(int sum, int[] arr, int index) {
		if(index == arr.length || sum < 0) {
			return 0;
		}
		
		if(sum == 0) {
			return 1;
			
		}
		
		
		int option1 = findTotalWays(sum - arr[index], arr, index);
		int option2 = findTotalWays(sum, arr, index+1);
		
		return option1 + option2;
	}

}
