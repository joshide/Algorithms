package revision3;

public class RodCuttingProblem {

	private static int[] store = null;
	public static void main(String[] args) {
		int[] prices = {1,5,8,9,10,17,17,20,24,0};
		store = new int[prices.length+1];
		
		int maxPrice = getMaxPrice(prices,prices.length);
		
		System.out.println(maxPrice);

	}
	
	private static int getMaxPrice(int[] prices, int length) {
		
		if(length == 0) {
			return 0;
		}
		
		if(store[length] != 0) {
			//System.out.println("result");
			return store[length];
		}
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < length; i++) {
			max = Math.max(max,prices[i] + getMaxPrice(prices, length-i-1));
		}
		
		store[length] = max;
		return store[length];
	}

}
