package revision.arrays;

public class MaximumSumPathInTwoArrays {

	public static void main(String[] args) {
		int[] arr1 = {0,10,12,0};
		int[] arr2 = {0,5,7,9};
		
		int sum = getMaximumSum(arr1,arr2,0,0,false, false);
		System.out.println(sum);

	}
	
	private static int getMaximumSum(int[] arr1, int[] arr2, int index1, int index2, boolean path1, boolean path2) {
		
		if(index1 >= arr1.length || index2 >= arr1.length) {
			return 0;
		}
		int option1 = 0;
		int option2 = 0;
		if(arr1[index1] == arr2[index2]) {
			option1 = getMaximumSum(arr1, arr2, index1+1, index2+1, true, false);
			option2 =  getMaximumSum(arr1, arr2, index1+1, index2+1, false, true);
			return arr1[index1] + Math.max(option1, option2);
		} else {
			if(path1) {
				return arr1[index1] + getMaximumSum(arr1, arr2, index1+1, index2+1, true, false);
			} else {
				return arr2[index1] + getMaximumSum(arr1, arr2, index1+1, index2+1, false, true);
			}
		}
		
	}

}
