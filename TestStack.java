package stack;
import stack.Stack.StackEmptyException;
import stack.Stack.StackFullException;

public class TestStack
{
	public static void main (String[] args)
	{
		System.out.println("Creating stack of capacity = 4:");
		Stack myStack = new Stack(4);
		System.out.println(myStack.isEmpty() == true ? "Stack is empty" : "Stack is not empty");
		System.out.println(myStack.isFull() == true ? "Stack is full" : "Stack is not full");
		System.out.println("List size is " + myStack.size());
		System.out.println();
		
		System.out.println("Trying to peek empty stack:");
		try {
			myStack.peek();
			System.out.println("Error: Stack empty was expected");
		} catch (StackEmptyException e) {
			System.out.println("Stack is empty, as expected");
		}
		System.out.println("Trying to pop empty stack:");
		try {
			myStack.pop();
			System.out.println("Error: Stack empty was expected");
		} catch (StackEmptyException e) {
			System.out.println("Stack is empty, as expected");
		}
		System.out.println();
		
		System.out.println("Pushing 10, 20, 30, and 40:");
		try {
			myStack.push(10);
			myStack.push(20);
			myStack.push(30);
			myStack.push(40);
			System.out.println(myStack.isEmpty() == true ? "Stack is empty" : "Stack is not empty");
			System.out.println(myStack.isFull() == true ? "Stack is full" : "Stack is not full");
			System.out.println("List size is " + myStack.size());
			myStack.printData();
		} catch (StackFullException e) {
			e.printStackTrace();
		}
		
		System.out.println("Trying to add beyond capacity:");
		try {
			myStack.push(50);
			System.out.println("Error: Stack full was expected");
		} catch (StackFullException e) {
			System.out.println("Stack is full, as expected");
			System.out.println();
		}

		try {
			System.out.println("Peeking the stack:");
			System.out.println("Value at top of stack: " + myStack.peek());
			System.out.println("Popping the stack:");
			System.out.println("Value at top of stack: " + myStack.pop());
			myStack.printData();
		} catch (StackEmptyException e) {
			e.printStackTrace();
		}
		
		System.out.println("Resetting stack to be 10, 20, 50, 0:");
		try {
			myStack.pop();
			myStack.push(50);
			myStack.push(0);
			myStack.printData();
		} catch (StackFullException | StackEmptyException e) {
			e.printStackTrace();
		}
		
		System.out.println("Sorting values in descening order:");
		myStack.sort();
		myStack.printData();
	}
}