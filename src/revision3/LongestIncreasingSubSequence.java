package revision3;

public class LongestIncreasingSubSequence {
	
	private static int[] lis = null;
	public static void main(String[] args) {
		int[] arr = {10, 22, 9, 33, 21, 50, 41, 60, 80};
		lis = new int[arr.length];
		int size = longestIncreasingSubSequenceSize(arr);
		
		System.out.println(size);
	}


private static int longestIncreasingSubSequenceSize(int[] arr) {
	for(int i = 0; i < arr.length; i++) {
		lis[i] = 1;
	}
	
	for(int i = arr.length -2; i >=0; i--) {
		int j = i+1;
		int max = lis[i];
		while(j < arr.length) {
			if(arr[j] > arr[i]) {
				max = Math.max(max, lis[j]);
			}
			j++ ;
		}
		lis[i] = 1 + max;
	}
	
	
	
	int max = lis[0];
	for(int number: lis) {
		max = Math.max(max, number);
	}
	
	return max;
}

}
