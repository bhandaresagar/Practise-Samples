package edu.iu.sagar.linkedlist;

public class DoubleNode
{
	public DoubleNode(int data)
	{
		this.data = data;
	}

	public int data;
	public DoubleNode next;

	public DoubleNode previous;

	public DoubleNode getPrevious()
	{
		return this.previous;
	}

	public void setPrevious(DoubleNode previous)
	{
		this.previous = previous;
	}

	@Override
	public String toString()
	{
		return "DoubleNode [data=" + this.data + ", next=" + this.next + ", previous="
				+ this.previous + "]";
	}

}
