package geeksforgeeks.dynamic_programming;

public class LongestCommonSubsequence {

	private static int[][] store = null;
	private static String[][] storeStr = null;
	private static StringBuilder str = new StringBuilder();
	public static void main(String[] args) {
		//AGGTAB
		String[] arr1 = {"A","G","G","T","A","B"};
		
		//GXTXAYB
		String[] arr2 = {"G","X","T","X","A","Y","B"};
		
		store = new int[arr1.length][arr2.length];
		storeStr = new String[arr1.length][arr2.length];
		
		int size = longestCommonSubsequnece(arr1,arr2, 0, 0);
		System.out.println(size);
	
		System.out.println(longestCommonSubsequneceString(arr1, arr2, 0, 0));

}
	
	private static int longestCommonSubsequnece(String[] arr1, String[] arr2, int index1, int index2) {
		if(index1 >= arr1.length || index2 >= arr2.length) {
			return 0;
		}
		
		if(store[index1][index2] != 0) {
			return store[index1][index2];
		}
		int result = 0;
		if(arr1[index1] == arr2[index2]) {
			result =  1 + longestCommonSubsequnece(arr1, arr2, index1+1, index2+1);
			
		} else {
			int result1 = longestCommonSubsequnece(arr1, arr2, index1+1, index2);
			int result2 = longestCommonSubsequnece(arr1, arr2, index1, index2+1);
			result =  Math.max(result1, result2);	
		}
		store[index1][index2] = result;
		return result;
		
	}
	
	private static String longestCommonSubsequneceString(String[] arr1, String[] arr2, int index1, int index2) {
		if(index1 >= arr1.length || index2 >= arr2.length) {
			return "";
		}
		
		if(storeStr[index1][index2] != null) {
			return storeStr[index1][index2];
		}
		String result = "";
		if(arr1[index1] == arr2[index2]) {
			result =  arr1[index1] + longestCommonSubsequneceString(arr1, arr2, index1+1, index2+1);
			
		} else {
			String result1 = longestCommonSubsequneceString(arr1, arr2, index1+1, index2);
			String result2 = longestCommonSubsequneceString(arr1, arr2, index1, index2+1);
			if(result1.length() > result2.length())
				result = result1;
			else
				result = result2;
		}
		storeStr[index1][index2] = result;
		return result;
		
	}
		
}
