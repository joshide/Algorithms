package coreman;

public class QueueBasicOperations {

	// head represents the index of the element that needs to be dequeued
	// tail represents the index where next element should be enqueued
	// when head == tail, the queue is empty
	// when head = tail + 1, the queue is full
	// this technique inserts only n - 1 elements in the array of size n
	private static int head = 0;
	private static int tail = 0;
	
	public static void main(String[] args) {
		
		int[] arr = new int[4];

		enqueue(arr, 1); enqueue(arr, 2); enqueue(arr, 3); enqueue(arr, 4);
		
		//enqueue(arr, 5);
		
		System.out.println(dequeue(arr));
		System.out.println(dequeue(arr));
		System.out.println(dequeue(arr));
		
		enqueue(arr, 5);
		enqueue(arr, 6);
		//enqueue(arr, 7);
		System.out.println(dequeue(arr));
		System.out.println(dequeue(arr));
		System.out.println(dequeue(arr));
		//System.out.println(dequeue(arr));
		
		enqueue(arr, 7);
		enqueue(arr, 8);
		enqueue(arr, 9);
		//enqueue(arr, 8);
		
		System.out.println(dequeue(arr));
		System.out.println(dequeue(arr));
		System.out.println(dequeue(arr));
	}
	
	private static void enqueue(int[] arr, int element) {
		// check for overflow condition
		if(tail == arr.length) {
			if(head == 0) {
				throw new RuntimeException("Queue Overflows");
			}
			else {
				tail = 0; // wrap-up condition
			}
		}
		if(head == tail + 1) {
			throw new RuntimeException("Queue Overflows");
		}
		
		// if not overflow
		arr[tail] = element;
		tail = tail + 1;
	}
	
	private static int dequeue(int[] arr) {
		if(head == arr.length) { // wrap-up condition
			head = 0;
		}
		
		if(head == tail) {
			throw new RuntimeException("Queue underflows");
		}
		
		int element = arr[head];
		arr[head] = 0;
		head = head + 1;
		return element;
	}

}
