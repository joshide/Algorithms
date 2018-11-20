package geeksforgeeks.dynamic_programming;

public class MaximumProductCutting {

	private static int[] store = null;
	public static void main(String[] args) {
		
		int n = 10;
		
		store = new int[n+1];
		
		int result = getMaximumProduct(n);
		
		System.out.println(result);
	}
	
	private static int getMaximumProduct(int n) {
		if(n == 1) {
			return 0;
		}
		
		if(store[n] != 0) {
			//System.out.println("result");
			return store[n];
		}
		int product = 1;
		for(int i = 1; i < n ; i ++) {
			int p1 = i * getMaximumProduct(n-i);
			int p2 = i * (n-i);
			int max = Math.max(p1, p2);
			product = Math.max(product, max);
		}
		
		store[n] = product;
		
		return product;
	}

}
