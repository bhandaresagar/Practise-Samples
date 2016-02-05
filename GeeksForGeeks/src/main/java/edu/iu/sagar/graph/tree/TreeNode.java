package edu.iu.sagar.graph.tree;

public class TreeNode
{
	TreeNode left, right;
	int data;

	public TreeNode(int data)
	{
		this.data = data;
	}

	public TreeNode getLeft()
	{
		return this.left;
	}

	public void setLeft(TreeNode left)
	{
		this.left = left;
	}

	public TreeNode getRight()
	{
		return this.right;
	}

	public void setRight(TreeNode right)
	{
		this.right = right;
	}

	public int getData()
	{
		return this.data;
	}

	public void setData(int data)
	{
		this.data = data;
	}

	@Override
	public String toString()
	{
		return "TreeNode [data=" + this.data + " left=" + this.left + ", right=" + this.right + "]";
	}

}
