package revision.cormen;

public class MergeSort {

	// Best Case, Average Case, Worst Case : O(nlogn)
	public static void main(String[] args) {
		int[] arr = {5,4,3,2,1};
		
		mergeSort(arr,0, arr.length-1);
		
		for(int number : arr) {
			System.out.print(number + ",");
		}

	}
	
	private static void mergeSort(int[] arr, int start, int end) {
		
		if(start == end) {
			return;
		}
		
		int mid = (start+end)/2;
		mergeSort(arr,start,mid);
		mergeSort(arr,mid+1,end);
		merge(arr, start, mid, end);
		
	}
	
	private static void merge(int[] arr, int start, int mid, int end) {
		
		int[] leftArr = new int[mid-start+1];
		int[] rightArr = new int[end-mid];
		
		int index = 0;
		for(int i = start; i <= mid; i++) {
			leftArr[index] = arr[i];
			index++;
		}
		
		index = 0;
		
		for(int i = mid+1; i <= end; i++) {
			rightArr[index] = arr[i];
			index++;
		}
		
		int i = 0;
		int j = 0;
		for(int k = start; k <= end; k++) {
			
			if(i == leftArr.length) {
				arr[k] = rightArr[j];
				j++;
				continue;
			}
			
			if(j == rightArr.length) {
				arr[k] = leftArr[i];
				i++;
				continue;
			}
			
			if(leftArr[i] < rightArr[j]) {
				arr[k] = leftArr[i];
				i++;
			} else {
				arr[k] = rightArr[j];
				j++;
			}	
		}
	}

}
