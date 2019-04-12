package Revision2;

public class HeapSort {

	private static int heapSize = 0;
	public static void main(String[] args) {
		
		int[] arr = {4,1,3,2,16,9,10,14,8,7};
		heapSize = arr.length - 1;
		
		buildMaxHeap(arr);
		
		heapSort(arr);
		
		for(int number : arr) {
			System.out.print(number + ",");
		}
		
	}
	
	//BestCase/WorstCase/AverageCase : O(nlogn)
	private static void heapSort(int[] arr) {
		for(int i = arr.length-1; i >=1; i--) {
			int max = arr[0];
			arr[0] = arr[i];
			arr[i] = max;
			heapSize--;
			maxHeapify(arr, 0);
		}
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
