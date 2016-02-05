package edu.iu.sagar.linkedlist;

public class DoubleLinkedList
{

	DoubleNode head;

	public static void main(String[] args)
	{
		DoubleLinkedList linkedList = DoubleLinkedList.generateList();
		linkedList.displayData();
		linkedList.insertAtFront(0);
		linkedList.insertAtLast(1000);
		linkedList.displayData();
		linkedList.reverse();
		linkedList.displayData();
		linkedList.head = linkedList.mergeSort(linkedList.head);
		linkedList.displayData();
		linkedList.displayDataWithP();
	}

	public DoubleNode mergeSort(DoubleNode head)
	{
		if (head.next == null)
		{
			return head;
		}

		// split into lists of equal size recursively(use hare and tortoise
		// algo)
		DoubleNode slow = head, fast = head.next.next;

		while (fast != null)
		{
			fast = fast.next;

			if (fast != null)
			{
				fast = fast.next;
				slow = slow.next;
			}
		}

		DoubleNode secondHalf = slow.next;
		slow.next = null;
		head.previous = null;
		secondHalf.previous = null;

		// first half
		DoubleNode a = mergeSort(head);
		// second half
		DoubleNode b = mergeSort(secondHalf);

		// merge the two halves
		return merge(a, b);

	}

	public DoubleNode merge(DoubleNode a, DoubleNode b)
	{

		if (a == null)
		{
			return b;
		}

		if (b == null)
		{
			return a;
		}

		DoubleNode result = null;

		if (a.data < b.data)
		{
			result = a;
			b.previous = result;
			result.next = merge(a.next, b);
		} else
		{
			result = b;
			a.previous = result;
			result.next = merge(a, b.next);
		}

		return result;

	}

	public void reverse()
	{
		DoubleNode head = this.head;

		if (head != null)
		{
			DoubleNode node = null;

			while (head != null)
			{
				node = head;
				DoubleNode tmp = head.next;
				head.next = head.previous;
				head.previous = tmp;
				head = head.previous;
			}

			this.head = node;
		}
	}

	public void displayData()
	{
		System.out.println();
		DoubleNode node = this.head;
		while (node != null)
		{
			System.out.print(node.data + " ");
			node = node.next;
		}
	}
	
	public void displayDataWithP()
	{
		System.out.println();
		DoubleNode node = this.head;
		while (node.next != null)
		{
			node = node.next;
		}
		
		while(node != null)
		{
			System.out.print(node.data + " ");
			node = node.previous;
		}
	}

	public void insertAtFront(int data)
	{
		DoubleNode node = new DoubleNode(data);

		if (head == null)
		{
			this.head = node;
		} else
		{
			node.next = this.head;
			head.previous = node;
			this.head = node;
		}
	}

	public void insertAtLast(int data)
	{
		DoubleNode node = new DoubleNode(data);

		if (head == null)
		{
			this.head = node;
		} else
		{
			DoubleNode doubleNode = this.head;
			while (doubleNode.next != null)
			{
				doubleNode = doubleNode.next;
			}

			doubleNode.next = node;
			node.previous = doubleNode;
		}
	}

	public static DoubleLinkedList generateList()
	{
		DoubleLinkedList linkedList = new DoubleLinkedList();
		linkedList.head = new DoubleNode(1);
		linkedList.head.previous = null;

		DoubleNode last = linkedList.head;
		for (int i = 2; i < 12; i++)
		{
			DoubleNode node = new DoubleNode(i);
			last.next = node;
			node.previous = last;
			last = node;
		}

		return linkedList;
	}

}
