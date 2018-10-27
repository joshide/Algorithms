package coreman;

import javax.management.RuntimeErrorException;

public class StackBasicOperations {

	//top represents the index of the most recently inserted element, i.e the top of the stack
	private static int top = -1;
	
	public static void main(String[] args) {
		
		int[] arr = new int[3];
		
		push(arr, 1); push(arr, 2); push(arr, 3); 
		
		System.out.println(pop(arr));
		
		System.out.println(pop(arr));
		
		push(arr,4); push(arr, 5);
		
		System.out.println(pop(arr));
		
		System.out.println(pop(arr));
		
		System.out.println(pop(arr));
		
		push(arr, 7); push(arr, 8); push(arr, 9);
		
		System.out.println(pop(arr));
		
		System.out.println(pop(arr));
		
		System.out.println(pop(arr));

	}
	
	private static void push(int[] arr, int element) {
		top = top + 1;
		if(top == arr.length) {
			top = top -1;
			throw new RuntimeException("Stack overflows");	
		}
		arr[top] = element;
	}
	
	private static int pop(int[] arr) {
		if(top == -1) {
			throw new RuntimeException("Stack Underflows");
		}
		int value = arr[top];
		top = top - 1;
		return value;
	}

}
