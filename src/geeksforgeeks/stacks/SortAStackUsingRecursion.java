package geeksforgeeks.stacks;

import java.util.Stack;

public class SortAStackUsingRecursion {

	public static void main(String[] args) {
		
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(2);
		stack.push(1);
		stack.push(3);
		
		stack = sort(stack);
		
		while(!stack.isEmpty()) {
			System.out.print(stack.pop() + ",");
		}

	}
	
	private static Stack<Integer> sort(Stack<Integer> stack) {
		if(stack.isEmpty() || stack.size() == 1)
			return stack;
		
		Integer element = stack.pop();
		Stack<Integer> sortedStack = sort(stack);
		return insertIntoSortedStack(sortedStack, element);
	}
	
	private static Stack<Integer> insertIntoSortedStack(Stack<Integer> stack, int element) {
		if(stack.isEmpty() || element < stack.firstElement()) {
			stack.push(element);
			return stack;
		}
		
		Integer poppedElement = stack.pop();
		Stack<Integer> sortedStack = insertIntoSortedStack(stack, element);
		sortedStack.push(poppedElement);
		
		return sortedStack;
	}

}
