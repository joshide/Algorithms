package revision.arrays;

public class MajorityElementInSortedArray {

	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 3, 3, 3, 10};
		int element = 3;
		
		int firstIndex = findFirstIndex(arr,element, 0, arr.length-1);
		System.out.println(firstIndex);
		
		int lastIndex = firstIndex + arr.length/2;
		if(lastIndex <= arr.length -1 && arr[lastIndex] == element) {
			System.out.println(element  + " is majority element");
		} else {
			System.out.println(element  + " is not majority element");
		}

	}
	
	private static int findFirstIndex(int[] arr, int element, int start, int end) {
		if(start == end) {
			if(arr[start] == element) {
				return start;
			} else {
				return -1;
			}
		}
		
		int mid = (start+end)/2;
		
		if(arr[mid] == element) {
			if(mid == 0) {
				return mid;
			} else if (arr[mid-1] < element) {
				return mid;
			} else {
				return findFirstIndex(arr, element, start, mid-1);
			}
		} else if (arr[mid] > element) {
			return findFirstIndex(arr, element, start, mid-1);
		} else {
			return findFirstIndex(arr, element, mid+1, end);
		}
	}

}
