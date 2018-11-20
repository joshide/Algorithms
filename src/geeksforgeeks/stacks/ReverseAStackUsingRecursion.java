package geeksforgeeks.stacks;

import java.util.Stack;

public class ReverseAStackUsingRecursion {

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		
		stack = reverse(stack);
		
		while(!stack.isEmpty()) {
			System.out.print(stack.pop() + ",");
		}

	}
	
	private static Stack<Integer> reverse(Stack<Integer> stack) {
		if(stack.isEmpty() || stack.size() == 1)
			return stack;
		
		Integer element = (Integer) stack.pop();
		Stack<Integer> reverseStack = reverse(stack);
		stack = new Stack<Integer>();
		stack.push(element);
		stack.addAll(reverseStack);
		return stack;
	}

}
