package sorting;

public class CountSort {
	
	// not in-place algorithm
	// linear time sorting : O(n+k)
	// stable sort
	
	public static void main(String[] args) {
		int arr[] = {4,3,2,1,5,2,6,4,3,1,0};
		
		arr = countSort(arr);
		
		for(int n: arr) {
			System.out.print(n+", ");
		}
	}
	
	private static  int[] countSort(int[] arr) {
		int max = Integer.MIN_VALUE;
		
		for(int number : arr) {
			if(number > max) {
				max = number;
			}
		}
		
		int [] c = new int[max+1];
		
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
