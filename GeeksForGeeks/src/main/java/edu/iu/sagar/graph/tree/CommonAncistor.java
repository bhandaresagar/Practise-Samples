package edu.iu.sagar.graph.tree;

public class CommonAncistor
{
	class Result
	{
		TreeNode res;
		boolean isAsyn;

		public Result(TreeNode res, boolean isAsyn)
		{
			super();
			this.res = res;
			this.isAsyn = isAsyn;
		}
	}

	public TreeNode getCommonAncistor(TreeNode root, int p, int q)
	{
		return commonAhelper(root, p, q).res;
	}

	private Result commonAhelper(TreeNode root, int p, int q)
	{
		if (root == null)
		{
			return new Result(null, false);
		}

		if (root.data == p && root.data == q)
		{
			return new Result(root, true);
		}

		Result rx = commonAhelper(root.left, p, q);

		if (rx != null && rx.isAsyn)
		{
			return rx;
		}

		Result ry = commonAhelper(root.right, p, q);

		if (ry != null && ry.isAsyn)
		{
			return ry;
		}

		if (rx.res != null && ry.res != null)
		{
			return new Result(root, true);
		} else
		{
			if (root.data == p || root.data == q)
			{
				return new Result(root, rx.res != null || ry.res != null ? true : false);
			}

			return new Result(rx.res != null ? rx.res : ry.res, false);
		}
	}
}
