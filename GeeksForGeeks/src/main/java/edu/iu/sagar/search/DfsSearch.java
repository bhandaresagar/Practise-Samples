package edu.iu.sagar.search;

import java.util.Stack;

public class DfsSearch
{
	int m = 10, n = 5;
	int[][] nos = new int[m][n];

	{
		for (int i = 0; i < m; i++)
		{
			for (int j = 0; j < n; j++)
			{
				nos[i][j] = (int) (Math.random() * 10) % 2;
				System.out.print(nos[i][j] + ", ");
			}
			System.out.println();
		}
	}

	class Node
	{
		int x;
		int y;

		public Node(int x, int y)
		{
			super();
			this.x = x;
			this.y = y;
		}

	}

	Stack<Node> lands = new Stack<Node>();

	public int getIlands()
	{
		int sum = 0;

		for (int i = 0; i < m; i++)
		{
			for (int j = 0; j < n; j++)
			{
				if (nos[i][j] == 1)
				{
					sum++;

					lands.push(new Node(i, j));

					while (!lands.isEmpty())
					{
						Node curr = lands.pop();
						
						int x = curr.x;
						int y = curr.y;
						
						if (x < m && x >= 0 && y < n && y >= 0
								&& nos[x][y] == 1)
						{
							nos[curr.x][curr.y] = 0;
							lands.push(new Node(x + 1, y));
							lands.push(new Node(i - 1, y));
							lands.push(new Node(x, y + 1));
							lands.push(new Node(x, y - 1));
						}
					}
				}
			}
		}

		return sum;
	}

	public static void main(String[] args)
	{
		DfsSearch search = new DfsSearch();
		System.out.println(search.getIlands());
	}
}
