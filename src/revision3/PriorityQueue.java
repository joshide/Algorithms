package revision3;

public class PriorityQueue {

	private static int heapSize = 0;
	public static void main(String[] args) {
		//Max/Min Heap can be used as a PriorityQueue
		int[] arr = {4,1,3,2,16,9,10,14,8,7};
		heapSize = arr.length - 1;
		
		buildMaxHeap(arr);
		
		//CRUD operations
		
		//Read
		System.out.println(getMaxElement(arr));
		
		//Update
		update(arr,5,20);
		System.out.println(getMaxElement(arr));
		
		//create
		
		//Delete
		System.out.println(delete(arr));
		System.out.println(getMaxElement(arr));
	}
	
	private static int delete(int[] arr) {
		int max = arr[0];
		arr[0] = arr[heapSize];
		arr[heapSize] = max;
		maxHeapify(arr,0);
		return max;
	}
	
	private static void create(int[] arr, int value) {
		heapSize++;
		arr[heapSize] = Integer.MIN_VALUE;
		update(arr,heapSize,value);
	}
	
	private static void update(int[] arr, int i, int value) {
		if(value < arr[i]) {
			maxHeapify(arr, i);
		} else {
			arr[i] = value;
			int parent = (i-1)/2;
			while(parent >= 0 && arr[i] > arr[parent]) {
				int temp = arr[i];
				arr[i] = arr[parent];
				arr[parent] = temp;
				i = parent;
				parent = (i-1)/2;
			}
		}
	}
	
	private static int getMaxElement(int[] arr) {
		return arr[0];
	}
	
	private static void buildMaxHeap(int[] arr) {
		
		for(int i = arr.length/2 -1; i >= 0; i--) {
			maxHeapify(arr,i);
		}
	}
	
	private static void maxHeapify(int[] arr, int i) {
		int largest = i;
		
		int left = 2*i + 1;
		int right = 2*i+2;
		
		if(left <= heapSize && arr[left] > arr[largest]) {
			largest = left;
		}
		
		if(right <= heapSize && arr[right] > arr[largest]) {
			largest = right;
		}
		
		if(largest != i) {
			int temp = arr[i];
			arr[i] = arr[largest];
			arr[largest] = temp;
			maxHeapify(arr,largest);
		}
	}

}
