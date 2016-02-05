package edu.iu.sagar.graph.tree;

public class BinaryTree
{
	TreeNode head;

	public static TreeNode getBalancedBinaryTree()
	{
		TreeNode node = new TreeNode(5);

		return node;
	}

	public void insertChild(int data)
	{
		if (head == null)
		{
			head = new TreeNode(data);
		} else
		{
			insertChild(data, head);
		}
	}

	private void printInorder(TreeNode node)
	{
		if (node == null)
		{
			return;
		}

		printInorder(node.left);
		System.out.print(node.data + (node.left != null ? "L" : "")
				+ (node.right != null ? "R" : "") + ", ");
		printInorder(node.right);
	}

	public void printInorder()
	{
		if (head != null)
		{
			printInorder(head);
		}
		System.out.println();
	}

	private void insertChild(int data, TreeNode node)
	{
		if(node == null)
		{
			return;
		}
		
		if (data < node.data)
		{
			if (node.left == null)
			{
				node.left = new TreeNode(data);
			}
			else
			{
				insertChild(data, node.left);
			}

		} else
		{
			if (node.right == null)
			{
				node.right = new TreeNode(data);
			}
			else
			{
				insertChild(data, node.right);
			}
		}
	}

	public void deleteNode(int data)
	{
		if (head.data == data)
		{
			head = replaceNode(data, head);
		} else
		{
			deleteNode(data, head);
		}
	}

	public void deleteNode(int data, TreeNode node)
	{
		if (node == null)
		{
			return;
		}

		if (node.left != null && head.left.data == data)
		{
			node.left = replaceNode(data, node.left);
		} else if (node.right != null && node.right.data == data)
		{
			node.right = replaceNode(data, node.right);
		} else if (data < node.data)
		{
			deleteNode(data, node.left);
		} else
		{
			deleteNode(data, node.right);
		}
	}

	public TreeNode replaceNode(int data, TreeNode head)
	{
		// choose left
		if (head.left != null)
		{
			TreeNode right = head.right;
			head = head.left;

			TreeNode tmp = head;

			if (right != null)
			{
				while (tmp.right != null)
				{
					tmp = tmp.right;
				}

				tmp.right = right;
			}

		} else if (head.right != null)
		{
			TreeNode left = head.left;
			head = head.right;

			TreeNode tmp = head;

			if (left != null)
			{
				while (tmp.left != null)
				{
					tmp = tmp.left;
				}

				tmp.left = left;
			}
		}

		return head;
	}

	class TreeInfo
	{
		boolean balanced;
		int depth;

		public TreeInfo(boolean balanced, int depth)
		{
			super();
			this.balanced = balanced;
			this.depth = depth;
		}

		@Override
		public String toString()
		{
			return "TreeInfo [balanced=" + this.balanced + ", depth=" + this.depth + "]";
		}

	}

	public TreeInfo isBalanced(TreeNode node)
	{

		if (node == null)
		{
			return new TreeInfo(true, 0);
		}

		// left tree depth
		TreeInfo linfo = isBalanced(node.left);
		TreeInfo rinfo = isBalanced(node.right);

		if (!linfo.balanced || !rinfo.balanced)
		{
			return new TreeInfo(false, -1);
		}

		if (Math.abs(linfo.depth - rinfo.depth) > 1)
		{
			return new TreeInfo(false, 0);
		} else
		{
			return new TreeInfo(true, Math.max(linfo.depth + 1, rinfo.depth + 1));
		}
	}

	public boolean isBalanced()
	{
		return isBalanced(head).balanced;
	}

	public static void main(String[] args)
	{

		/*
		 * BinaryTree tree1 = new BinaryTree(); tree1.insertChild(20); TreeNode
		 * head = tree1.head;
		 * 
		 * head.left = new TreeNode(10); head.right = new TreeNode(30);
		 * head.left.left = null; head.left.right = new TreeNode(15);
		 * 
		 * tree1.printInorder(); System.out.println(tree1.isBST());
		 */

		//
		// /*
		// * tree.insertChild(2); tree.insertChild(10); tree.insertChild(3);
		// * tree.insertChild(8);
		// */
		//
		// tree.printInorder();
		// System.out.println(tree.isBalanced());

		int[] sortedArray = new int[] { 2, 3, 5, 7, 8, 9, 12, 56, 78 };

		BinaryTree t = new BinaryTree();

		for (int i : sortedArray)
		{
			t.insertChild(i);
		}

		t.printInorder();
		int lh = t.getHeight(t.head.left);
		int rh = t.getHeight(t.head.right);

		System.out.println(lh + " " + rh);

		BinaryTree tree2 = new BinaryTree();

		// tree with minimum height BinaryTree tree2 = new BinaryTree();
		tree2.insertBalanced(0, sortedArray.length - 1, sortedArray, tree2);
		tree2.printInorder();
		lh = tree2.getHeight(tree2.head.left);
		rh = tree2.getHeight(tree2.head.right);
		System.out.println(lh + " " + rh + " BST: " + tree2.isBST());
		
		tree2.deleteNode(3);
		
		tree2.printInorder();
		
		lh = tree2.getHeight(tree2.head.left);
		rh = tree2.getHeight(tree2.head.right);
		System.out.println(lh + " " + rh + " BST: " + tree2.isBST());

	}

	public void insertBalanced(int left, int right, int[] sortedArray, BinaryTree t)
	{
		if (left <= right)
		{
			int mid = (left + right) / 2;
			t.insertChild(sortedArray[mid]);
			insertBalanced(left, mid - 1, sortedArray, t);
			insertBalanced(mid + 1, right, sortedArray, t);
		}
	}

	public int getHeight(TreeNode node)
	{
		if (node == null)
		{
			return 0;
		}

		int lheight = 0, rheight = 0;

		if (node.left != null)
		{
			lheight = getHeight(node.left);
		}

		if (node.right != null)
		{
			rheight = getHeight(node.right);
		}

		return Math.max(lheight, rheight) + 1;
	}

	private boolean isBST(int min, int max, TreeNode node)
	{
		if (node == null)
		{
			return true;
		}

		if (node.data <= min || node.data > max)
		{
			return false;
		}

		return true & isBST(min, node.data, node.left) & isBST(node.data, max, node.right);
	}

	public boolean isBST()
	{
		return isBST(Integer.MIN_VALUE, Integer.MAX_VALUE, head);
	}

	@Override
	public String toString()
	{
		return "BinaryTree [head=" + this.head + "]";
	}
}
