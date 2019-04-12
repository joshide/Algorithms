package revision3;

public class CountSort {

	public static void main(String[] args) {
		int[] arr = {5,4,3,2,1};
		
		arr = countSort(arr);
		
		for(int number : arr) {
			System.out.print(number + ",");
		}

	}
	
	//Extra Space
	//Best/Average/Worst: O(n)
	private static int[] countSort(int[] arr) {
		int[] b = new int[arr.length];
		
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
		
		for(int i = arr.length-1; i >=0; i--) {
			b[c[arr[i]] -1] = arr[i];
			c[arr[i]] = c[arr[i]] - 1;
		}
		return b;
	}

}
