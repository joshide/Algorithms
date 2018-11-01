package geeksforgeeks.arrays;

import java.util.function.BinaryOperator;

public class SearchAnElementInSortedAndRotatedArray {

	public static void main(String[] args) {
		int[] arr = {3,4,5,1,2};
		
		boolean found = findElement(arr,2);
		System.out.println(found);
		
		arr = new int[] {1,2,3,4};
		
		int pi = findIndexOfPivotElement(arr, 0, arr.length-1);
		System.out.println(pi);
	}

	private static boolean findElement(int[] arr, int element) {
		
		int pivotElementIndex = findIndexOfPivotElement(arr, 0, arr.length - 1);
		
		System.out.println("PivotElementIndex: " + pivotElementIndex);
		
		if( element > arr[0])
			return binarySearch(arr, 0, pivotElementIndex, element);
		else
			return binarySearch(arr, pivotElementIndex+1, arr.length-1, element);
	}
	
	private static boolean binarySearch(int[] arr, int start, int end, int element) {
		
		if(start > end) {
			return false;
		}
		
		int mid = (start+end)/2;
		
		if(arr[mid] == element)
			return true;
		
		if(arr[mid] > element) {
			return binarySearch(arr, start, mid-1, element);
		} else {
			return binarySearch(arr, mid+1, end, element);
		}
	}
	
	private static int findIndexOfPivotElement(int[] arr, int start, int end) {
		
		if(start == end) {
			return start;
		}
		
		int mid = (start + end)/2;
		
		
		if(mid+1 < arr.length && arr[mid] > arr[mid+1] && mid-1 >= 0 && arr[mid] > arr[mid-1]) {
			return mid;
		}
		
		if(mid == 0 && arr[mid] > arr[mid+1])
			return mid;
		
		if(mid == arr.length -1 && arr[mid] > arr[mid-1])
			return mid;
		
		if(arr[start] <= arr[mid]) {
			return findIndexOfPivotElement(arr, mid+1, end);
		} else {
			return findIndexOfPivotElement(arr, start, mid-1);
		}
		
	}
}
