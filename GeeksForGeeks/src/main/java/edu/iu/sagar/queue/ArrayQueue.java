package edu.iu.sagar.queue;

import java.util.ArrayList;
import java.util.List;

public class ArrayQueue<T>
{
	private List<T> data = new ArrayList<T>();;

	public void queue(T val)
	{
		data.add(val);
	}

	public T dequeue()
	{
		if (data.isEmpty())
		{
			throw new ArrayIndexOutOfBoundsException("Queue is empty");
		}

		return data.remove(0);
	}
}
