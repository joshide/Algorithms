package revision.arrays;

public class SubsetSumProblem {

	private static boolean[][] store;
	public static void main(String[] args) {
		int[] arr = {3, 34, 4, 12, 5, 2};
		int value = 9;
		
		store = new boolean [arr.length][value+1];
		
		boolean result = isSubSetExists(arr,value,0);
		System.out.println(result);

	}
	
	private static boolean isSubSetExists(int[] arr, int value, int index) {
		if(value < 0) {
			return false;
		}
		
		if(value == 0) {
			return true;
		}
		
		if(index >= arr.length) {
			return false;
		}
		
		if(store[index][value] != false) {
			System.out.println("result");
			return store[index][value];
		}
		
		boolean option1 = isSubSetExists(arr, value-arr[index], index+1);
		boolean option2 = isSubSetExists(arr, value, index+1);
		
		store[index][value] = option1 || option2;
		
		return store[index][value];
	}

}
