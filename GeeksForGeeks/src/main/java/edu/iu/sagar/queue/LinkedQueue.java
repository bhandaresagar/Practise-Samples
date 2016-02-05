package edu.iu.sagar.queue;

public class LinkedQueue<T>
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

	LinkedStackNode<T> head, tail;

	int total = 0;

	public void queue(T val)
	{
		LinkedStackNode<T> node = new LinkedStackNode<T>(val, null);

		if (total == 0)
		{
			head = node;
			tail = head;
		} else
		{
			tail.next = node;
			tail = tail.next;
		}

		total++;
	}

	public T dequeue()
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
