package geeksforgeeks.arrays;

public class ConstructionOfLongestIncreasingSequence {

	public static void main(String[] args) {
		int[] arr = {10,22,9,33,21,50,41,60,80};
		
		printLIS(arr);

	}
	
	private static void printLIS(int[] arr) { // to get the DP solution instead of int, return an element
		
		element[] lis = new element[arr.length];
		
		for(int i = 0; i < lis.length; i++) {
			lis[i] = new element(1, ""+arr[i]);
		}
		int max = Integer.MIN_VALUE;
		for(int i = arr.length-2; i >=0; i--) {
			max = 0;
			int index = i;
			for(int j = i+1; j < arr.length; j++) {
				if(arr[j] > arr[i]) {
					if(lis[j].size > max) {
						max = lis[j].size;
						index = j;
					}
				}
			}
			lis[i].size = 1 + max;
			lis[i].value = lis[i].value  + "," + lis[index].value;
		}
		
		
		String value = lis[0].value;
		int size = lis[0].size;
		for(int i = 1; i < lis.length; i++) {
			if(lis[i].size > size) {
				size = lis[i].size;
				value = lis[i].value;
				//System.out.println(value + "1");
			}
		}
		
		System.out.println(size);
		System.out.println(value);
	}

}

class element {
	int size;
	String value;
	
	element(int size, String value) {
		this.size = size;
		this.value = value;
	}
}
