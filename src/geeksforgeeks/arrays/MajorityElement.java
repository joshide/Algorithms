package geeksforgeeks.arrays;

public class MajorityElement {

	public static void main(String[] args) {
		int arr[] = {3, 3, 4, 2, 4, 4, 2, 4, 4};
		int majorityElement = findMajorityElement(arr);
		
		System.out.println("Majority Element is: " + majorityElement);

	}
	
	private static int findMajorityElement(int[] arr) {
		
		int candidateElement = findCandidateElement(arr);
		
		int count = 0;
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == candidateElement) {
				count++;
			}
		}
		
		if(count > arr.length/2)
			return candidateElement;
		else
			return -1;
	}
	
	private static int findCandidateElement(int[] arr) {
		int candidateElement = arr[0];
		int count = 1;
		
		for(int i = 1; i < arr.length; i++) {
			
			if(arr[i] == candidateElement) {
				count++;
			} else {
				count --;
			}
			
			if(count == 0) {
				i++;
				candidateElement = arr[i];
				count = 1;
			}
		}
		
		return candidateElement;
	}

}
