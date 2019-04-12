package Revision2;

public class InsertionSort {

	public static void main(String[] args) {
		int[] arr = {5,4,3,2,1};
		
		insertionSort(arr);
		
		for(int number : arr) {
			System.out.print(number + ",");
		}
		

	}
	
	// Worst Case and Average Case Complexity : O(n^2)
	// Best Case Complexity : O(n)
	private static void insertionSort(int[] arr) {
		
		for(int i = 1; i < arr.length; i++) {
			int key = arr[i];
			int j = i-1;
			while(j >= 0 && arr[j] > key) {
				arr[j+1] = arr[j];
				j--;
			}
			arr[j+1] = key;
		}
	}

}
