package cormen;

public class Heaps {

	private static int heapSize=0;
	public static void main(String[] args) {
		// Max Heap and Min Heap
		// Build Max Heap : O(n)
		// Heap Sort : O(nLogn)
		
		int[] arr = {4,1,3,2,16,9,10,14,8,7};
		heapSize = arr.length;
		
		heapSort(arr);
		
	}
	
	private static void heapSort(int[] arr) {
		buildMaxHeap(arr);
		
		System.out.println("Array after maxHeap");
		for(int number : arr) {
			System.out.print(number +",");
		}
		
		System.out.println("\nArray After HeapSort");
		for(int i = arr.length-1; i > 0; i--) {
			int max = arr[0];
			arr[0] = arr[i];
			arr[i] = max;
			heapSize--;
			maxHeapify(arr, 0);
		}
		
		for(int number : arr) {
			System.out.print(number +",");
		}
		
	}
	
	private static void buildMaxHeap(int[] arr) {
		for(int i = arr.length/2-1; i >= 0; i--) {
			maxHeapify(arr, i);
		}
	}
	
	private static void maxHeapify(int[] arr, int i) {
		int largest = i;
		
		int left = 2*i+1;
		int right = 2*i+2;
		
		if(left < heapSize && arr[left] > arr[largest]) {
			largest = left;
		}
		
		if(right < heapSize && arr[right] > arr[largest]) {
			largest = right;
		}
		
		if(largest != i) {
			int temp = arr[i];
			arr[i] = arr[largest];
			arr[largest] = temp;
			maxHeapify(arr, largest);
		}
	}

}
