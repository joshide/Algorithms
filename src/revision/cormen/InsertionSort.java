package revision.cormen;

public class InsertionSort {

	// Best Case : O(n)
	// Worst Case and Average Case : O(n2)
	public static void main(String[] args) {
		int[] arr = {5,4,3,2,1};
		
		insertionSort(arr);
		
		for(int number : arr) {
			System.out.print(number+",");
		}

	}
	
	private static void insertionSort(int[] arr) {
		
		for(int i = 1; i < arr.length; i++) {
			int key = arr[i];
			int j = i-1;
			while(j >=0 && arr[j] > key) {
				arr[j+1] = arr[j];
				j--;
			}
			arr[j+1] = key;
		}
	}

}
