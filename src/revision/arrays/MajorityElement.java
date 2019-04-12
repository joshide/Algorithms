package revision.arrays;

public class MajorityElement {

	public static void main(String[] args) {
		int[] arr = {3, 3, 4, 2, 4, 4, 2, 4};
		
		int candidateElement = findCandidateElement(arr);
		System.out.println("Candidate Element is: " + candidateElement);
		
		int occurances = 0;
		for(int number : arr) {
			if(number == candidateElement) {
				occurances++;
			}
		}
		
		if(occurances > arr.length/2) {
			System.out.println("Majority Element : " + candidateElement );
		} else {
			System.out.println("No Majority Element");
		}

	}
	
	// Moore's voting Algorithm
	private static int findCandidateElement(int[] arr) {
		int count = 1;
		int candidateElement = arr[0];
		
		for(int i = 1; i < arr.length; i++) {
			if(arr[i] == candidateElement) {
				count = count + 1;
			} else {
				count = count -1;
			}
			
			if(count == 0) {
				candidateElement = arr[i];
				count = 1;
			}
		}
		
		return candidateElement;
	}

}
