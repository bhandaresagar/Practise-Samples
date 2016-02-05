package edu.iu.sagar.search;

import java.util.LinkedList;
import java.util.Queue;

public class BfsSearch
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

	Queue<Node> queue = new LinkedList<Node>();

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

					queue.add(new Node(i, j));

					while (!queue.isEmpty())
					{
						Node curr = queue.poll();
						
						int x = curr.x;
						int y = curr.y;
						
						if (x < m && x >= 0 && y < n && y >= 0
								&& nos[x][y] == 1)
						{
							nos[curr.x][curr.y] = 0;
							queue.add(new Node(x + 1, y));
							queue.add(new Node(i - 1, y));
							queue.add(new Node(x, y + 1));
							queue.add(new Node(x, y - 1));
						}
					}
				}
			}
		}

		return sum;
	}

	public static void main(String[] args)
	{
		BfsSearch search = new BfsSearch();
		System.out.println(search.getIlands());
	}
}
