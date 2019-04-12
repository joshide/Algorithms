package Revision2;

public class RodCuttingProblem {

	public static void main(String[] args) {
		int[] prices = {1,5,8,9,10,17,17,20,24,0};
		
		int maxmimumProfit = getMaximumProfit(prices, prices.length);
		System.out.println(maxmimumProfit);

	}
	
	private static int getMaximumProfit(int[] prices, int length) {
		if(length <= 0) {
			return 0;
		}
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < length; i++) {
			max = Math.max(max, prices[i] + getMaximumProfit(prices, length-i-1));
		}
		
		return max;
	}

}
