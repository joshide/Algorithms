package geeksforgeeks.dynamic_programming;

public class NumberOfWaysToCoverADistance {

	private static int[] store = null;
	public static void main(String[] args) {
		int distance = 4;
		store = new int[distance+1];
		
		// steps can be 1, 2 or 3 steps
		
		int number = numberOfWaysToCoverADistance(distance);
		System.out.println(number);

	}
	
	private static int numberOfWaysToCoverADistance(int distance) {
		if(distance == 0) {
			return 1;
		}
		
		if(distance <= 0) {
			return 0;
		}
		if(store[distance] != 0) {
			return store[distance];
		}
		int sum = 0;
		for(int i = 1; i <= 3; i++) {
			sum = sum + numberOfWaysToCoverADistance(distance-i);
		}
		
		store[distance] = sum;
		
		return sum;
	}

}
