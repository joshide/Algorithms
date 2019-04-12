package revision.cormen;

public class PriorityQueueUsingMaxHeap {

	//Max Heap or Min Heap can also be used as a priority queue
	// where the root of the heap is always the most priority(max or min) element
	// We can do below set of operations to have Heap as a Priority Queue
	// Read
	// Delete ( Retrieve)
	// Update the value
	// Create or insert a new element
	private static int heapSize = 0;
	public static void main(String[] args) {
		int[] arr = {4,1,3,2,16,9,10,14,8,7};
		heapSize = arr.length-1;
		
		buildMaxHeap(arr);

	}
	
	private static int readMaxHeap(int[] arr) {
		return arr[0];
	}
	
	private static int extractMaxHeap(int[] arr) {
		int maxValue = arr[0];
		arr[0] = arr[heapSize];
		arr[heapSize] = maxValue;
		heapSize--;
		maxHeapify(arr, 0);
		return maxValue;
	}
	
	private static void update(int[] arr, int index, int key) {
		if(key < arr[index]) {
			throw new RuntimeException("Provided value is less than the actual value");
		}
		arr[index] = key;
		int parentIndex = (index-1)/2;
		while(parentIndex >= 0 && arr[index] > arr[parentIndex]) {
			int temp = arr[index];
			arr[index] = arr[parentIndex];
			arr[parentIndex] = temp;
			index = parentIndex;
			parentIndex = (index-1)/2;
		}
	}
	
	private static void insert(int[] arr, int value) {
		heapSize++;
		arr[heapSize] = Integer.MIN_VALUE;
		update(arr, heapSize, value);
	}
	
	// Time Complexity Of BuildMaxHeap is O(n)
	private static void buildMaxHeap(int[] arr) {
		int number = arr.length/2 - 1;
		
		for(int i = number; i >=0; i--) {
			maxHeapify(arr,i);
		}
	}
	
	// maxHeapify works on the assumption that both left and right child's subtree are max heap
	// Time Complexity of BuildMaxHeap is O(Logn)
	private static void maxHeapify(int[] arr, int index) {
		int largestIndex = index;
		int leftChildIndex = 2*index + 1;
		int rightChildIndex = 2*index + 2;
		
		if(leftChildIndex <= heapSize && arr[leftChildIndex] > arr[largestIndex]) {
			largestIndex = leftChildIndex;
		}
		
		if( rightChildIndex <= heapSize && arr[rightChildIndex] > arr[largestIndex]) {
			largestIndex = rightChildIndex;
		}
		
		if(largestIndex != index) {
			int temp = arr[index];
			arr[index] = arr[largestIndex];
			arr[largestIndex] = temp;
			maxHeapify(arr,largestIndex);
		}
	}

}
