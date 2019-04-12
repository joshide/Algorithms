package Revision2;

public class MergeSort {

	public static void main(String[] args) {
		int[] arr = {5,4,3,2,1};
		
		mergeSort(arr,0,arr.length-1);
		
		for(int number : arr) {
			System.out.print(number + ",");
		}

	}
	
	// WorstCase/AverageCase/BestCase : O(nlogn)
	private static void mergeSort(int[] arr, int start, int end) {
		if(start == end) {
			return;
		}
		
		int mid = (start+end)/2;
		mergeSort(arr,start,mid);
		mergeSort(arr,mid+1, end);
		merge(arr,start,mid,end);
	}
	
	private static void merge(int[] arr, int start, int mid, int end) {
		int[] leftArr = new int[mid-start+1];
		int[] rightArr = new int[end-mid];
		
		int index = 0;
		for(int i = start; i <=mid; i++) {
			leftArr[index] = arr[i];
			index++;
		}
		
		index = 0;
		
		for(int i = mid+1; i <= end; i++) {
			rightArr[index] = arr[i];
			index++;
		}
		
		int leftIndex = 0;
		int rightIndex = 0;
		for(int i = start; i <= end; i++) {
			
			if(leftIndex == leftArr.length) {
				arr[i] = rightArr[rightIndex];
				rightIndex++;
			}
			else if (rightIndex == rightArr.length) {
				arr[i] = leftArr[leftIndex];
				leftIndex++;
			}
			else if(leftArr[leftIndex] < rightArr[rightIndex]) {
				arr[i] = leftArr[leftIndex];
				leftIndex++;
			} else {
				arr[i] = rightArr[rightIndex];
				rightIndex++;
			}
		}
	}

}
