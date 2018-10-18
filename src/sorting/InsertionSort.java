package sorting;

public class InsertionSort {

	public static void main(String[] args) {
		// in place sorting algorithm
		// worst case and average case complexity : n2
		// best case complexity : n
		// Similar to how people sort cards
		
		int[] n = {5,4,3,2,1};
		
		insertionSort(n);
		
		for(int number : n) {
			System.out.print(number + ",");
		}
		
	}
	
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
