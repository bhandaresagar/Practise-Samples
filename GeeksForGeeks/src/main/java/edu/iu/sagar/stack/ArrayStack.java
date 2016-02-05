package edu.iu.sagar.stack;

import java.util.ArrayList;
import java.util.List;

public class ArrayStack<T>
{
	private List<T> data = new ArrayList<T>();;
	private int top = -1;

	public void push(T val)
	{
		data.add(val);
		++top;
	}

	public T pop()
	{
		if (top == -1)
		{
			throw new ArrayIndexOutOfBoundsException("Stack is empty");
		}

		return data.get(top--);
	}

}
