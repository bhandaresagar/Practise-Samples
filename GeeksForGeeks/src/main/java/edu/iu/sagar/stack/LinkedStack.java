package edu.iu.sagar.stack;

public class LinkedStack<T>
{
	class LinkedStackNode<M>
	{
		M data;
		LinkedStackNode<M> next;

		public LinkedStackNode(M data, LinkedStackNode<M> next)
		{
			super();
			this.data = data;
			this.next = next;
		}
	}

	LinkedStackNode<T> head;
	int total = 0;

	public void push(T val)
	{
		LinkedStackNode<T> node = new LinkedStackNode<T>(val, null);

		if (total == 0)
		{
			head = node;
		} else
		{
			node.next = head;
			head = node;
		}

		total++;
	}

	public T pop()
	{
		if (total == 0)
		{
			throw new ArrayIndexOutOfBoundsException("Stack is empty");
		}
		total--;
		LinkedStackNode<T> node = head;
		head = head.next;
		return node.data;
	}

}
