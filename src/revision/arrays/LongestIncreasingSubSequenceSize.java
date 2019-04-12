package revision.arrays;

public class LongestIncreasingSubSequenceSize {

	public static void main(String[] args) {
		int[] arr = {10, 22, 9, 33, 21, 50, 41, 60, 80};
		
		int size = findLongestIncreasingSubSequenceSize(arr);
		System.out.println(size);

	}
	
	private static int findLongestIncreasingSubSequenceSize(int[] arr) {
		int[] lis = new int[arr.length];
		for(int i = 0; i < lis.length; i++) {
			lis[i] = 1;
		}
		
		for(int i = arr.length-1; i >=0; i--) {
			int max = 0;
			for(int j = i+1; j < arr.length; j++) {
				if(arr[j] > arr[i]) {
					max = Math.max(max, lis[j]);
				}
			}
			lis[i] = lis[i] + max;
		}
		
		int max = 0;
		for(int number : lis) {
			max = Math.max(max, number);
		}
		
		return max;
	}

}
