package coreman;

public class BinarySearch {

	public static void main(String[] args) {
		int[] n = {1,2,4,5,6};
		int x = 3;
		
		boolean result = exists(n, x, 0, n.length -1);
		System.out.println(result);

	}
	
	private static boolean exists(int[] arr, int x, int start, int end) {
		if(start > end)
			return false;
		
		int mid = (start + end) /2;
		
		if(arr[mid] == x)
			return true;
		
		if(x < arr[mid])
			return exists(arr, x, start, mid -1);
		else
			return exists(arr, x, mid+1, end);
	}

}
