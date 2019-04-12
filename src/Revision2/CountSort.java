package Revision2;

public class CountSort {

	public static void main(String[] args) {
		int[] arr = {5,4,3,2,1,5,4,3,2,1};

		arr = countSort(arr);
		
		for(int number : arr) {
			System.out.print(number + ",");
		}
	}
	
	// Stable Sort
	// Extra Space
	//BestCase/AverageCase/WorstCase : O(n)
	// Radix Sort can be done using CountSort :O(d*n)
	private static int[] countSort(int[] arr) {
		int max = arr[0];
		for(int i = 1; i < arr.length; i++) {
			max = Math.max(max, arr[i]);
		}
		
		int[] c = new int[max+1];
		
		for(int i = 0; i < arr.length; i++) {
			c[arr[i]] = c[arr[i]] + 1;
		}
		
		for(int i = 1; i < c.length; i++) {
			c[i] = c[i] + c[i-1];
		}
		
		int[] b = new int[arr.length];
		
		for(int i = arr.length-1; i >=0; i--) {
			b[c[arr[i]]-1] = arr[i];
			c[arr[i]]--;
		}
		
		return b;
	}

}
