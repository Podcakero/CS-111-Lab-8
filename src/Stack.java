public class Stack<T> implements StackInterface<T>
{
	class Node
	{
		private Node next = null;
		private T element;

		public Node(T element)
		{
			this.element = element;
		}

		public Node getNext()
		{
			return next;
		}

		public void setNext(Node next)
		{
			this.next = next;
		}

		public T getValue()
		{
			return element;
		}
	}

	private int currentSize;
	private Node head;
	private Node tail;

	public Stack()
	{
		head = null;
		tail = null;
		currentSize = 0;
	}

	@Override
	public boolean isFull()
	{
		return false;
	}

	@Override
	public boolean isEmpty()
	{
		return head == null;
	}

	@Override
	public void push(T newValue)
	{
		Node node = new Node(newValue);

		//If the Stack is empty, set the Tail to the new Value
		if (tail == null)
			tail = node;

		//The next of the new head should be the current head
		node.setNext(head);
		head = node;
		currentSize++;
	}

	@Override
	public T pop()
	{
		//Check for empty Stack
		if (currentSize == 0)
			throw new StackException(("ERROR! Cannot pop on a empty stack"));

		currentSize--; //Decrement currentSize

		T val = head.getValue(); //Set the value to the value of the current Head
		head = head.next; //Move the current head

		return val; //Return the value
	}

	@Override
	public int size()
	{
		return currentSize;
	}

	@Override
	public int getMaxSize()
	{
		return Integer.MAX_VALUE;
	}

	public String toString()
	{
		String output = "[";
		Node current = head;

		//Go to the second to last Node.
		while (current != null && current.next != null)
		{
			output += current.getValue() + ", ";
			current = current.next;
		}

		//If we don't have an empty node, then we need to add the final element
		if (current != null)
			output += current.getValue();

		//Cap off of the output
		output += "]";

		return output;
	}
}
