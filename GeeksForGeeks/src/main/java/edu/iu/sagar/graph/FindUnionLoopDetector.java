package edu.iu.sagar.graph;

public class FindUnionLoopDetector implements LoopDetector
{

	int[] parent;

	@Override
	public boolean hasLoop(Graph graph)
	{
		Edge[] edges = graph.edges;

		parent = new int[graph.V];

		for (int i = 0; i < graph.V; i++)
		{
			parent[i] = -1;
		}

		boolean hasLoop = false;

		for (int i = 0; i < edges.length; i++)
		{
			Edge edge = edges[i];

			if (edge == null)
			{
				break;
			}

			int parX = findParent(edge.src);
			int parY = findParent(edge.dest);

			if (parX == parY)
			{
				hasLoop = true;
				break;
			}

			parent[parX] = parY;
		}

		return hasLoop;
	}

	private int findParent(int i)
	{
		if (parent[i] == -1)
		{
			return i;
		}

		return findParent(parent[i]);
	}

}
