package geeksforgeeks.arrays;

public class CeilingOfANumberInSortedArray {

	public static void main(String[] args) {
		int[] arr = {1,4,8,12};
		int element = 14;
		
		int ceiling = findCeiling(arr,0,arr.length-1,element);
		System.out.println(ceiling);
	}
	
	private static int findCeiling(int[] arr, int start, int end, int x) {
		
		if(x < arr[0])
			return arr[0];
		
		if(x > arr[arr.length -1])
			return -1;
		
		if(start == end)
			return arr[start];
		
		// else ceiling lies between 1 and arr.lenght -1
		
		int mid = (start+end)/2;
		
		if(arr[mid] == x)
			return arr[mid];
		
		if(arr[mid] > x ) {
			
			if(arr[mid-1] < x) {
				return arr[mid];
			}
			else return findCeiling(arr, start, mid-1, x);
		} 
		return findCeiling(arr, mid+1, end, x);
	}

}
