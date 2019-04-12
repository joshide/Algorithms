package revision.arrays;

public class RearrangePositiveAndNegativeNumber {

	public static void main(String[] args) {
		int[] arr = {12,11,-13,-5,6,-7,5,-3,-6};
		
		rearrange(arr);
		for(int number : arr) {
			System.out.print(number + ",");
		}

	}
	
	private static void rearrange(int[] arr) {
		
		for(int i = 1; i < arr.length; i++) {
			int key = arr[i];
			
			int j = i-1;
			
			while(j >= 0) {
				
				if(key * arr[j] >= 0) {
					break;
				}
				if(key < arr[j]) {
					arr[j+1] = arr[j];
					j--;
				} else {
					break;
				}
				
			}
			arr[j+1] = key;
		}
	}

}
