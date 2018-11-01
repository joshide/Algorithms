package geeksforgeeks.arrays;

public class CheckMajorityElementInSortedArray {

	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 3, 3, 3, 10};
		int element = 3;
		
		int firstIndexOfElement = findFirstIndex(arr, 0, arr.length -1, element);
		System.out.println(firstIndexOfElement);
		
		int lastIndex = firstIndexOfElement + arr.length/2;
		if(lastIndex < arr.length && arr[lastIndex] == element) 
			System.out.println("majority element");
		else
			System.out.println("not a majority element");

	}
	
	private static int findFirstIndex(int[] arr, int start, int end, int element) {
		
		if(start == end) {
			if(arr[start] == element)
				return start;
			else
				return -1;
		}
		
		int mid = (start+end)/2;
		
		if(arr[mid] == element) {
			if(mid == 0 || arr[mid-1] < element) {
				return mid;
			} else {
				return findFirstIndex(arr, start, mid-1, element);
			}		
		} else if (arr[mid] > element) {
			return findFirstIndex(arr, start, mid-1, element);
		} else
			return findFirstIndex(arr, mid+1, end, element);
	}

}
