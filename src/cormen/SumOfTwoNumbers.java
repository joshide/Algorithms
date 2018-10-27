package cormen;

public class SumOfTwoNumbers {

	public static void main(String[] args) {
		// Given and unsorted array and a number x find if there exists two numbers in
		// array whose sum is exactly x in nlogn time
		
		int[] n = {5,4,3,2,1};
		// first sort the array using any n log n sorting algorithm
		MergeSort.mergeSort(n, 0, n.length-1);
		
		for(int i : n) {
			System.out.print(i+",");
		}
		
		int x = 7;
		
		findNumbers(n, x);

	}
	
	private static void findNumbers(int[] arr, int x) {
		int i = 0;
		int j = arr.length-1;
		
		while(i < j) {
			int sum = arr[i] + arr[j];
			if(sum == x) {
				System.out.println(arr[i] + " and " + arr[j] );
				return;
			} else if (sum > x) {
				j--;
			} else {
				i++;
			}
		}
	}

}
