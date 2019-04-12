package revision.cormen;

public class HeapSort {

	private static int heapSize = 0;
	public static void main(String[] args) {
		int[] arr = {4,1,3,2,16,9,10,14,8,7};
		heapSize = arr.length-1;
		
		// we need to sort this array using heap sort
		// Before we can use heap sort, we need to make this array a max heap data structure
		// A max heap data structure is a complete binary tree data structure, where the node is greater than both of its children
		// except the leaf nodes as they don't have any children
		
		buildMaxHeap(arr);
		
		System.out.println("Array after converting it to max heap data stcuture");
		for(int number : arr) {
			System.out.print(number + ",");
		}
		
		heapSort(arr);
		
		System.out.println("\nArray after heap sort");
		for(int number : arr) {
			System.out.print(number + ",");
		}

	}
	
	private static void heapSort(int[] arr) {
		for(int i = arr.length-1; i >=1; i--) {
			int max = arr[0];
			arr[0] = arr[i];
			arr[i] = max;
			heapSize = heapSize - 1;
			maxHeapify(arr,0);
		}
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
