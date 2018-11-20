package geeksforgeeks.dynamic_programming;

public class KnapsackProblem {

	private static int[][] store = null;
	public static void main(String[] args) {
		int[] weights = {10,20,30};
		int[] values = {60,100,120};
		int w = 50;
		
		store = new int[w+1][values.length];
		int result = findMaxValue(weights,values,w,0);
		System.out.println(result);

	}
	
	private static int findMaxValue(int[] weights, int[] values, int w, int index) {
		if(index >= weights.length)
			return 0;
		
		if(store[w][index] != 0) {
			System.out.println("result");
			return store[w][index];
		}
		
		int option1 = 0;
		if(weights[index] <= w) {
			option1 = values[index] + findMaxValue(weights, values, w-weights[index], index+1);
		}
		
		int option2 = findMaxValue(weights, values, w, index+1);
		
		store[w][index] = Math.max(option1, option2);
		
		return store[w][index];
	}

}
