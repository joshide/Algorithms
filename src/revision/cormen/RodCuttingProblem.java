package revision.cormen;

public class RodCuttingProblem {

	private static int[] store = null;
	public static void main(String[] args) {
		int[] price = {1,5,8,9,10,17,17,20,24,30};
		store = new int[price.length];
		
		int result = findMaxSum(price, price.length-1);
		
		System.out.println(result);

	}
	
	private static int findMaxSum(int[] price, int length) {
		if(length < 0) {
			return 0;
		}
		if(length == 0) {
			return price[0];
		}
		
		if(store[length] != 0) {
			return store[length];
		}
		
		
		int max = 0;
		for(int i = 0; i <= length; i++) {
			max = Math.max(max,price[i] + findMaxSum(price, length-i-1));
		}
		store[length] = max;
		return max;
	}

}
