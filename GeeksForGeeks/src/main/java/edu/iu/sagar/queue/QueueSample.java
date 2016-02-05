package edu.iu.sagar.queue;

public class QueueSample
{
	public static void main(String[] args)
	{
		ArrayQueue<Integer> arrayStack = new ArrayQueue<Integer>();

		System.out.print("Queue: ");
		for (int i = 0; i < 10; i++)
		{
			arrayStack.queue(i);
			System.out.print(i + ", ");
		}
		System.out.print("\nDequeue: ");

		for (int i = 0; i < 10; i++)
		{
			System.out.print(arrayStack.dequeue() + ", ");
		}

		LinkedQueue<Character> linkedStack = new LinkedQueue<Character>();

		String name = "sagar";
		System.out.print("\n\nQueue: " + name);
		
		for (char c : name.toCharArray())
		{
			linkedStack.queue(c);
		}

		System.out.print("\nDequeue: ");

		for (int i = 0; i < name.length(); i++)
		{
			System.out.print(linkedStack.dequeue() + ", ");
		}

	}
}
