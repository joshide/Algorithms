package cormen;

public class MergeSort {
	
	// require extra space
	// worst case, average case and best case complexity : nlogn
	
	private static int numOfInversions = 0;
	public static void main(String[] args) {
		
		int[] arr = {5,4,3,2,1};
		mergeSort(arr,0, arr.length-1);
		
		for(int n : arr) {
			System.out.print(n +",");
		}
		
		System.out.println("\nNumberOfInversions " + numOfInversions);
	}
	
	public static void mergeSort(int[] arr, int start, int end) {
		
		if(start < end) {
			int mid = (start + end)/2;
			mergeSort(arr, start, mid);
			mergeSort(arr, mid+1, end);
			merge(arr, start, mid, end);
		}
		
	}
	
	private static void merge(int[] arr, int start, int mid, int end) {
		int n1 = mid - start + 1;
		int n2 = end - mid;
		
		int left[] = new int[n1];
		int right[] = new int[n2];
		
		int k = 0;
		for(int i = start; i <= mid; i++) {
			left[k] = arr[i];
			k++;
		}
		k = 0;
		for(int i = mid+1; i <= end; i++) {
			right[k] = arr[i];
			k++;
		}
		
		int i = 0;
		int j = 0;
		
		for(k = start; k <= end; k++) {
			if(i == left.length) {
				arr[k] = right[j];
				j++;
				continue;
			}
			
			if(j == right.length) {
				arr[k] = left[i];
				i++;
				continue;
			}
			
			if(left[i] <= right[j]) {
				arr[k] = left[i];
				i++;
			} else {
				arr[k] = right[j];
				j++;
				numOfInversions = numOfInversions + (left.length - i);
			}
		}
	}

}
