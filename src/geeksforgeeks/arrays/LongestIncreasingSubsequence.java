package geeksforgeeks.arrays;

public class LongestIncreasingSubsequence {

	public static void main(String[] args) {
		int[] arr = {10,22,9,33,21,50,41,60,80};
		
		int sizeOfLIS = findSizeOfLIS(arr);

	}
	
	private static int findSizeOfLIS(int[] arr) {
		int[] sizeArr = new int[arr.length];
		
		for(int i = 0; i < arr.length; i++) {
			sizeArr[i] = 1;
		}
		
		int size = 0;
		
		for(int i = arr.length-2; i >=0; i--) {
			size = 0;
			for(int j = i+1; j < arr.length; j++) {
				if(arr[j] > arr[i]) {
					size = Math.max(size, sizeArr[j]);
				}
			}
			sizeArr[i] = sizeArr[i] + size;
		}
		
		int maxSize = 0;
		for(int i = 0; i < arr.length; i++) {
			System.out.print(sizeArr[i] +",");
			maxSize = Math.max(maxSize, sizeArr[i]);
		}
		
		return maxSize;
	}

}
