package edu.iu.sagar.linkedlist;

public class SimpleNode
{
	public int data;
	public SimpleNode next;

	public SimpleNode(int data)
	{
		super();
		this.data = data;
	}

	public int getData()
	{
		return this.data;
	}

	public void setData(int data)
	{
		this.data = data;
	}

	public SimpleNode getNext()
	{
		return this.next;
	}

	public void setNext(SimpleNode next)
	{
		this.next = next;
	}

	@Override
	public String toString()
	{
		return "SimpleNode [data=" + this.data + ", next=" + this.next + "]";
	}

}
