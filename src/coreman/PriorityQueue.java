package coreman;

public class PriorityQueue {

	private static int heapSize = 0;
	public static void main(String[] args) {
		//Max priority Queue
		// Min Priority Queue
		// Max priority Queue based on Max Heap data Structure
		// Min Priority Queue based on Min Heap data Structure
		
		int[] arr = {4,1,3,2,16,9,10,14,8,7};
		heapSize = arr.length;
		
		buildMaxHeap(arr);
		
		System.out.println("Array after max heap");
		
		for(int number: arr) {
			System.out.print(number +",");
		}
		
		//Extract Max
		System.out.println("\nMax Value: " + extractMax(arr));
		
		//Remove Max
		
		System.out.println("Returned Max Value: " + removeMax(arr));
		System.out.println("Array after remove maximum value");
		for(int number: arr) {
			System.out.print(number +",");
		}
		
		// Increase key
		increaseKey(arr,4,20);
		System.out.println("\nHeap after increase in value");
		for(int number: arr) {
			System.out.print(number +",");
		}
		

	}
	
	private static int extractMax(int[] arr) {
		return arr[0];
	}
	
	private static int removeMax(int[] arr) {
		int max = arr[0];
		arr[0] = arr[heapSize-1];
		arr[heapSize-1] = max;
		heapSize--;
		maxHeapify(arr, 0);
		return max;
	}
	
	private static void increaseKey(int[] arr, int index, int value) {
		if(value <= arr[index])
			throw new RuntimeException("Provided value is less than the exiting value");
		
		arr[index] = value;
		int parentIndex = (index-1)/2;
		
		while(parentIndex >= 0 && arr[parentIndex] < arr[index]) {
			int parentValue = arr[parentIndex];
			arr[parentIndex] = arr[index];
			arr[index] = parentValue;
			index = parentIndex;
			parentIndex = (index-1)/2;
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
