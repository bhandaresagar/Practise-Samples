package edu.iu.sagar.linkedlist;

import edu.iu.sagar.sorting.MergeSort;

public class SimpleLinkedList
{

	public SimpleNode head;

	public static void main(String[] args)
	{
		SimpleLinkedList pal = SimpleLinkedList.generateListWithPal();
		pal.displayData();
		System.out.println("Is palindrome: " + pal.isPalindrome(pal.head));
		System.out.println("Is palindrome: " + pal.isPalindrome(pal.head, pal.head).result);
		SimpleLinkedList linkedList = SimpleLinkedList.generateList();
		linkedList.displayData();

		// add to front
		linkedList.insertFront(100);

		// add last
		linkedList.insertLast(50);

		// insert after 5
		linkedList.insertAfter(5, 25);

		linkedList.displayData();

		// delete 4
		linkedList.deleteDataFromList(4);

		linkedList.displayData();

		// delete pos[2]
		linkedList.deletePosFromList(2);

		linkedList.displayData();

		System.out.println("Node count: " + linkedList.getNodeCount());

		// search for 100, 24, 50
		System.out.println("100: " + linkedList.searchElement(100, linkedList.head));
		System.out.println("24: " + linkedList.searchElement(24, linkedList.head));
		System.out.println("50: " + linkedList.searchElement(50, linkedList.head));

		linkedList.swapNodes(100, 50);

		linkedList.displayData();
		SimpleNode node = linkedList.getNthNodeFromLast(13);

		if (node != null)
		{
			System.out.println("value 13th from last: " + node.data);
		}

		// reverse list
		linkedList.reverseList();
		
		linkedList.displayData();
		
		linkedList.head = linkedList.reverseList(linkedList.head);
		
		linkedList.displayData();
		linkedList.sagregateEvenOdd();
		linkedList.displayData();
		SimpleLinkedList loopList = SimpleLinkedList.generateListWithLoop();
		System.out.println();
		System.out.println("Have loop: " + loopList.floyedLoopDetect());

		System.out.println("Pairwise swap");
		linkedList.displayData();
		linkedList.pairwiseSwap();
		linkedList.displayData();

		MergeSort mergeSort = new MergeSort();
		SimpleNode head = mergeSort.mergeSort(linkedList);
		SimpleLinkedList sortedlist = new SimpleLinkedList();
		sortedlist.head = head;
		sortedlist.displayData();

		linkedList.sagregateEvenOdd();
		linkedList.displayData();

	}

	public void displayData()
	{
		System.out.println();
		SimpleNode node = this.head;
		while (node != null)
		{
			System.out.print(node.data + " ");
			node = node.next;
		}
	}

	public int getNodeCount()
	{
		int count = 0;

		SimpleNode node = this.head;

		while (node != null)
		{
			count++;
			node = node.next;
		}

		return count;
	}

	public void createHead(int data)
	{
		this.head = new SimpleNode(data);
	}

	public void deletePosFromList(int pos)
	{
		if (this.head != null)
		{

			if (pos == 1)
			{
				this.head = this.head.next;
			} else
			{
				SimpleNode node = this.head;
				int i = 1;
				while (node.next != null && ++i != pos)
				{
					node = node.next;
				}

				if (pos == i)
				{
					node.next = node.next.next;
				}

			}
		}
	}

	public void pairwiseSwap()
	{
		if (this.head != null)
		{
			SimpleNode curr = this.head, next = this.head.next;

			do
			{
				int tmp = curr.data;
				curr.data = next.data;
				next.data = tmp;
				curr = next.next;
				if (curr == null)
				{
					break;
				}
				next = curr.next;
			} while (next != null);
		}
	}

	SimpleNode tmpHead;

	public boolean isPalindrome(SimpleNode node)
	{
		boolean res = true;

		if (node.next != null)
		{
			res = isPalindrome(node.next);
		}

		boolean isSame = node.data == tmpHead.data;
		tmpHead = tmpHead.next;
		return isSame & res;
	}
	
	class result
	{
		boolean result;
		SimpleNode head;
		public result(boolean result, SimpleNode head)
		{
			super();
			this.result = result;
			this.head = head;
		}
		
	}
	
	public result isPalindrome(SimpleNode node, SimpleNode head)
	{
		boolean res = true;

		if (node.next != null)
		{
			result r = isPalindrome(node.next, head); 
			res = r.result;
			head = r.head;
		}

		boolean isSame = node.data == head.data;
		head = head.next;
		return new result(isSame & res, head);
	}

	public boolean floyedLoopDetect()
	{
		boolean loop = false;
		if (this.head != null)
		{
			SimpleNode fast = this.head, slow = this.head;

			while (fast != null && fast.next != null)
			{
				fast = fast.next;
				fast = fast.next;
				slow = slow.next;
				if (slow == fast)
				{
					loop = true;
					break;
				}
			}
		}
		return loop;
	}

	public void reverseList()
	{
		if (this.head != null)
		{
			SimpleNode curr = this.head, prev = null;

			while (curr != null)
			{
				SimpleNode tmp = curr.next;
				curr.next = prev;
				prev = curr;
				curr = tmp;
			}

			this.head = prev;
		}

	}

	public SimpleNode reverseList(SimpleNode node)
	{
		if (node.next == null)
		{
			return node;
		}

		SimpleNode old = reverseList(node.next);
		old.next = node;
		return old;
	}

	public void sagregateEvenOdd()
	{
		SimpleNode last = this.getLastNode();

		SimpleNode curr = this.head, prev = null;
		SimpleNode next = curr.next;
		int length = this.getNodeCount();

		while (length-- > 0)
		{
			if (curr.data % 2 == 1)
			{
				// odd, delete from here
				if (prev == null)
				{
					this.head = curr.next;
				} else
				{
					prev.next = curr.next;
				}
				next = curr.next;
				curr.next = null;
				last.next = curr;
				last = curr;
				curr = next;
			} else
			{
				prev = curr;
				curr = curr.next;
			}
		}
	}

	public void deleteDataFromList(int data)
	{
		if (this.head != null)
		{
			if (this.head.data == data)
			{
				this.head = this.head.next;
			} else
			{
				SimpleNode node = this.head;

				while (node.next != null && node.next.data != data)
				{
					node = node.next;
				}

				if (node.next != null)
				{
					node.next = node.next.next;
				}
			}
		}
	}

	public SimpleNode getNthNodeFromLast(int n)
	{
		SimpleNode lastP = this.head, currP = this.head;

		for (int i = 0; i < n && currP != null; i++)
		{
			currP = currP.next;
		}

		if (currP == null)
		{
			return null;
		}
		while (currP != null)
		{
			lastP = lastP.next;
			currP = currP.next;
		}

		return lastP;

	}

	public void swapNodes(int first, int second)
	{
		if (first != second && this.head != null && this.head.next != null)
		{
			SimpleNode currX = null, node = this.head, prevX = null;
			boolean gotX = false, gotY = false;
			SimpleNode currY = this.head, prevY = null;

			while (node != null && !(gotX && gotY))
			{
				if (node.data == first)
				{
					currX = node;
					gotX = true;
				}

				if (node.data == second)
				{
					gotY = true;
					currY = node;
				}

				if (!gotX)
					prevX = node;

				if (!gotY)
					prevY = node;

				node = node.next;
			}

			if (currX == null || currY == null)
			{
				return;
			}

			if (prevX == null)
			{
				this.head = currY;
			} else
			{
				prevX.next = currY;
			}

			if (prevY == null)
			{
				this.head = currX;
			} else
			{
				prevY.next = currX;
			}

			SimpleNode tmp = currX.next;
			currX.next = currY.next;
			currY.next = tmp;
		}
	}

	public void insertFront(int data)
	{
		if (head == null)
		{
			this.createHead(data);
			return;
		}

		SimpleNode node = new SimpleNode(data);
		node.next = head;
		this.head = node;
	}

	public void insertLast(int data)
	{
		if (head == null)
		{
			this.createHead(data);
			return;
		}
		SimpleNode node = new SimpleNode(data);
		this.getLastNode().next = node;
	}

	public void insertAfter(int previous, int data)
	{
		SimpleNode node = new SimpleNode(data);
		SimpleNode previousNNode = this.getGivenNode(previous);
		if (previousNNode != null)
		{
			node.next = previousNNode.next;
			previousNNode.next = node;
		}
	}

	public SimpleNode getLastNode()
	{
		SimpleNode node = this.head;
		while (node.next != null)
		{
			node = node.next;
		}

		return node;
	}

	public SimpleNode getGivenNode(int data)
	{
		SimpleNode node = this.head;
		while (node != null)
		{
			if (node.data == data)
			{
				break;
			}
			node = node.next;
		}

		return node;
	}

	public boolean searchElement(int data, SimpleNode root)
	{
		if (root == null)
		{
			return false;
		}

		if (root.data == data)
		{
			return true;
		}

		return searchElement(data, root.next);
	}

	public static SimpleLinkedList generateList()
	{
		SimpleLinkedList linkedList = new SimpleLinkedList();
		linkedList.head = new SimpleNode(1);
		SimpleNode last = linkedList.head;
		for (int i = 2; i < 12; i++)
		{
			SimpleNode node = new SimpleNode(i);
			last.next = node;
			last = node;
		}

		return linkedList;
	}

	public static SimpleLinkedList generateListWithLoop()
	{
		SimpleLinkedList linkedList = new SimpleLinkedList();
		linkedList.head = new SimpleNode(1);
		SimpleNode last = linkedList.head;

		for (int i = 2; i < 12; i++)
		{
			SimpleNode node = new SimpleNode(i);
			last.next = node;
			last = node;
		}
		last.next = linkedList.head;

		return linkedList;
	}

	public static SimpleLinkedList generateListWithPal()
	{
		SimpleLinkedList linkedList = new SimpleLinkedList();
		linkedList.head = new SimpleNode(1);
		SimpleNode last = linkedList.head;

		for (int i = 2, j = 12; i < 12; i++, j--)
		{
			SimpleNode node = new SimpleNode(Math.abs(i - j));
			last.next = node;
			last = node;
		}
		linkedList.head = linkedList.head.next.next;
		linkedList.tmpHead = linkedList.head;
		return linkedList;
	}

}
