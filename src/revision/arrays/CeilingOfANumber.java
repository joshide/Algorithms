package revision.arrays;

public class CeilingOfANumber {

	public static void main(String[] args) {
		int[] arr = {1,2,8,10,10,12,19};
		int x = 21;
		
		int ceiling = findCeiling(arr,x,0,arr.length-1);
		System.out.println(ceiling);

	}
	
	private static int findCeiling(int[] arr, int value, int start, int end) {
		if(value < arr[0]) {
			return arr[0];
		}
		
		if(value > arr[arr.length-1]) {
			return -1;
		}
		
		if(start == end) {
			return arr[start];
		}
		int mid = (start+end)/2;
		
		if(arr[mid] == value) {
			return value;
		}
		
		if(arr[mid] < value) {
			return findCeiling(arr, value, mid+1, end);
		} else  {
			if(mid -1 >=0 && arr[mid-1] < value) {
				return arr[mid];
			} else {
				return findCeiling(arr, value, start, mid-1);
			}
		}
	}

}
