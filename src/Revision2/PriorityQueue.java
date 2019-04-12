package Revision2;

public class PriorityQueue {

	private static int heapSize = 0;
	public static void main(String[] args) {
		// We can do all the priority queue operations(CRUD) using maxHeap or minHeap
		int[] arr = {4,1,3,2,16,9,10,14,8,7};
		heapSize = arr.length - 1;
		
		buildMaxHeap(arr);
		
		System.out.println("Max Element: " + read(arr));
		
		update(arr,9,20);
		
		System.out.println("Max heap after update operation " );
		for(int number : arr) {
			System.out.print(number + ",");
		}
		
		int deletedElement = delete(arr);
		System.out.println("\nDeleted Element :" + deletedElement);
		
		System.out.println("Max Element After Deletion:" + read(arr));
		
		System.out.println("Max Heap after deletion");
		for(int number : arr) {
			System.out.print(number + ",");
		}
		
		insert(arr,30);
		
		System.out.println("\nMax Heap after insertion");
		for(int number : arr) {
			System.out.print(number + ",");
		}

	}
	
	private static int read(int[] arr ) {
		return arr[0];
	}
	
	private static void update(int[] arr, int i, int value) {
		if(value  < arr[i]) {
			throw new RuntimeException("Provided Value is less than the original value");
		}
		
		int parent = (i-1)/2;
		arr[i] = value;
		while(parent >= 0 && arr[parent] < arr[i]) {
			int temp = arr[parent];
			arr[parent] = arr[i];
			arr[i] = temp;
			i = parent;
			parent = (i-1)/2;
		}
	}
	
	private static int delete(int[] arr) {
		int max = arr[0];
		arr[0] = arr[heapSize];
		arr[heapSize] = max;
		heapSize--;
		maxHeapify(arr, 0);
		return max;
	}
	
	private static void insert(int[] arr, int value) {
		heapSize++;
		arr[heapSize] = Integer.MIN_VALUE;
		update(arr, heapSize, value);
	}
		
	private static void buildMaxHeap(int[] arr) {
		for(int i = arr.length/2 -1; i >=0; i--) {
			maxHeapify(arr,i);
		}
	}
	
	private  static void maxHeapify(int[] arr, int i) {
		int leftChildIndex = 2*i + 1;
		int rightChildIndex = 2*i + 2;
		
		int largestIndex = i;
		
		if(leftChildIndex <= heapSize && arr[leftChildIndex] > arr[largestIndex]) {
			largestIndex = leftChildIndex;
		}
		
		if(rightChildIndex <= heapSize && arr[rightChildIndex] > arr[largestIndex]) {
			largestIndex = rightChildIndex; 
		}
		
		if(largestIndex != i) {
			int temp = arr[i];
			arr[i] = arr[largestIndex];
			arr[largestIndex] = temp;
			maxHeapify(arr, largestIndex);
		}
	}

}
