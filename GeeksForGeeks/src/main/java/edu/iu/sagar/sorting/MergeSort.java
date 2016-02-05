package edu.iu.sagar.sorting;

import edu.iu.sagar.linkedlist.SimpleLinkedList;
import edu.iu.sagar.linkedlist.SimpleNode;

public class MergeSort
{
	public SimpleNode mergeSort(SimpleLinkedList list)
	{
		SimpleNode slow = list.head;

		if (slow == null || slow.next == null)
		{
			return slow;
		}

		SimpleNode fast = slow.next.next;

		SimpleLinkedList listA = new SimpleLinkedList();
		listA.head = slow;

		SimpleLinkedList listB = new SimpleLinkedList();

		while (fast != null)
		{
			fast = fast.next;
			if (fast != null)
			{
				slow = slow.next;
				fast = fast.next;
			}
		}
		listB.head = slow.next;
		slow.next = null;

		SimpleNode left = mergeSort(listA);
		SimpleNode right = mergeSort(listB);
		return merge(left, right);
	}

	public SimpleNode merge(SimpleNode nodeA, SimpleNode nodeB)
	{
		if (nodeA == null)
		{
			return nodeB;
		}

		if (nodeB == null)
		{
			return nodeA;
		}

		SimpleNode result = null;

		if (nodeA.data < nodeB.data)
		{
			result = nodeA;
			result.next = merge(nodeA.next, nodeB);
		} else
		{
			result = nodeB;
			result.next = merge(nodeB.next, nodeA);
		}

		return result;
	}
}
