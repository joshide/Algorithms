package revision.cormen;

public class CountingSort {

	// Best Case, Average Case and Worst Case : O(n)
	// Insertion Sort and Merge Sort does not take extra space
	// But Count sort takes extra space
	// This is stable sort
	public static void main(String[] args) {
		int[] arr = {3,2,1,1,2,3};
		
		int[] b = countSort(arr);
		
		for(int number : b) {
			System.out.print(number + ",");
		}

	}
	
	private static int[] countSort(int[] arr) {
		int max = arr[0];
		for(int i = 1; i < arr.length; i++) {
			if(arr[i] > max) {
				max = arr[i];
			}
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
			c[arr[i]] = c[arr[i]] - 1;
		}
		
		return b;
 	}

}
