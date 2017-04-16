package stack;

public class Stack
{
	private int[] stackData;
	private int index = -1;
	
	public Stack(int size)
	{
		stackData = new int[size];
	}
	
	public boolean isFull()
	{
		return index >= stackData.length-1 ? true : false;
	}
	
	public boolean isEmpty()
	{
		return index < 0 ? true : false;
	}
	
	public void push(int data) throws StackFullException //O(1)
	{
		if(!isFull())
		{
			stackData[++index] = data;			
		}
		else
		{
			throw new StackFullException();
		}
	}
	
	public int peek() throws StackEmptyException //O(1)
	{
		if(!isEmpty())
		{
			return stackData[index];
		}
		else
		{
			throw new StackEmptyException();
		}		
	}
	
	public int pop() throws StackEmptyException //O(1)
	{
		if(!isEmpty())
		{
			return stackData[index--];
		}
		else
		{
			throw new StackEmptyException();
		}		
	}
	
	public int size()
	{
		return index + 1;
	}
	
	public void printData() //O(n)
	{	
		System.out.print("Stack Elements: ");
		for(int i = 0; i <= index; i++)
		{
			System.out.print(stackData[i]+ " ");
		}
		System.out.println();
		System.out.println();
	}
	
	public void sort()
	{
		Stack tempStack = new Stack(this.size());
		int temp = 0;
		while(!this.isEmpty())
		{
			try {
				temp = this.pop();
			} catch (StackEmptyException e) {
				e.printStackTrace();
			}
			try {
				while(!tempStack.isEmpty() && tempStack.peek() > temp)
				{
					try {
						this.push(tempStack.pop());
					} catch (StackFullException e) {
						e.printStackTrace();
					}
				}
			} catch (StackEmptyException e1) {
				e1.printStackTrace();
			}
			try {
				tempStack.push(temp);
			} catch (StackFullException e) {
				e.printStackTrace();
			}
		}
		
		while(!tempStack.isEmpty())
		{
			try {
				this.push(tempStack.pop());
			} catch (StackFullException e) {
				e.printStackTrace();
			} catch (StackEmptyException e) {
				e.printStackTrace();
			}
		}
	}

	public class StackEmptyException extends Exception
	{
		public String toString() {
		    return "StackEmptyException";
		}
	}
	
	public class StackFullException extends Exception
	{
		public String toString() {
		    return "StackFullException";
		}
	}	
}