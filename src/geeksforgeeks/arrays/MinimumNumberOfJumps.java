package geeksforgeeks.arrays;

public class MinimumNumberOfJumps {

	private static int [] store = null;
	public static void main(String[] args) {
		int[] arr = {1,3,5,8,9,2,6,7,6,8,9};
		store = new int[arr.length];
		int minJumps = findMinimumNumberOfJumpsToReachEnd(arr, 0);
		
		System.out.println(minJumps);

	}
	
	private static int findMinimumNumberOfJumpsToReachEnd(int[] arr, int index) {
		if(index >= arr.length-1)
			return 0;
		
		if(arr[index] < 1) 
			return Integer.MAX_VALUE;
		
		if(store[index] != 0) {
			//System.out.println(index);
			return store[index];
		}
		
		int minJumps = Integer.MAX_VALUE;
		
		int value = arr[index];
		for(int i = 1; i <= value; i++) {
			minJumps = Math.min(minJumps, 1 + findMinimumNumberOfJumpsToReachEnd(arr, index+i));
		}
		
		store[index] = minJumps;
		
		return minJumps;
		
	}

}
