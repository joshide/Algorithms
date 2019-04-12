package revision3;

public class MergeSort {

	public static void main(String[] args) {
		int[] arr = {5,4,3,2,1};
		
		mergeSort(arr,0 , arr.length-1);
		
		for(int number : arr) {
			System.out.print(number + ",");
		}
	}
	
	// Best, Average, Worst Case: O(nlogn)
	private static void mergeSort(int[] arr, int start, int end) {
		if(start == end) {
			return;
		}
		
		int mid = (start+end)/2;
		mergeSort(arr,start,mid);
		mergeSort(arr,mid+1,end);
		merge(arr,start,mid,end);
	}
	
	private static void merge(int[] arr, int start, int mid, int end) {
		int[] leftArr = new int[mid-start+1];
		int[] rightArr = new int[end-mid];
		
		int leftIndex = 0;
		int rightIndex = 0;
		
		for(int i = start; i <= mid; i++) {
			leftArr[leftIndex] = arr[i];
			leftIndex++;
		}
		
		for(int i = mid+1; i <= end; i++) {
			rightArr[rightIndex] = arr[i];
			rightIndex++;
		}
		
		leftIndex = rightIndex = 0;
		
		for(int i = start; i <= end; i++) {
			
			if(leftIndex >= leftArr.length) {
				arr[i] = rightArr[rightIndex];
				rightIndex++;
				continue;
			}
			
			if(rightIndex >= rightArr.length) {
				arr[i] = leftArr[leftIndex];
				leftIndex++;
				continue;
			}
			
			if(leftArr[leftIndex] <= rightArr[rightIndex]) {
				arr[i] = leftArr[leftIndex];
				leftIndex++;
			} else {
				arr[i] = rightArr[rightIndex];
				rightIndex++;
			}
		}
	}

}
