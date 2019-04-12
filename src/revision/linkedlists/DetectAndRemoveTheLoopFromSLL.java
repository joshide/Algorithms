package revision.linkedlists;

public class DetectAndRemoveTheLoopFromSLL {

	public static void main(String[] args) {
		/*
		 * Turquoise and hare Algorithms
		 * 1. Use two pointers  slow and fast
		 * 2. move slow by 1 point and fast by 2 points
		 * 3. if they meet somewhere, that mean that loop exists
		 * 4. let this meeting node be the candidate node
		 * 5. Use this information to get to know the size of the loop
		 * 6. Again make two pointers , one at start of the linked list, one at a head start of distance equals to size of the loop
		 * 7. they will meet at the starting of the loop
		 * 8. Using this information and size of the loop go the last node of the loop and make it next pointer to null.
		 */

	}

}
