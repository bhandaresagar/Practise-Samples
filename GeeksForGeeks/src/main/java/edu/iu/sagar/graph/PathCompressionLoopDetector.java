package edu.iu.sagar.graph;

public class PathCompressionLoopDetector implements LoopDetector
{
	class subsetInfo
	{
		int parent, rank;

		public subsetInfo(int parent, int rank)
		{
			super();
			this.parent = parent;
			this.rank = rank;
		}

		@Override
		public String toString()
		{
			return "subsetInfo [parent=" + this.parent + ", rank=" + this.rank + "]";
		}

	}

	subsetInfo[] parent;

	@Override
	public boolean hasLoop(Graph graph)
	{

		Edge[] edges = graph.edges;

		parent = new subsetInfo[graph.V];

		for (int i = 0; i < graph.V; i++)
		{
			parent[i] = new subsetInfo(i, 0);
		}

		boolean hasLoop = false;

		for (int i = 0; i < edges.length; i++)
		{
			Edge edge = edges[i];

			if (edge == null)
			{
				break;
			}

			int x = findParent(edge.src);
			int y = findParent(edge.dest);

			if (x == y)
			{
				hasLoop = true;
				break;
			}

			subsetInfo subX = parent[x];
			subsetInfo subY = parent[y];

			if (subX.rank > subY.rank)
			{
				parent[y].parent = x;
			} else if (subY.rank > subX.rank)
			{
				parent[x].parent = y;
			} else
			{
				parent[x].parent = y;
				parent[y].rank++;
			}
		}

		return hasLoop;
	}

	public int findParent(int vertex)
	{
		if (parent[vertex].parent == vertex)
		{
			return vertex;
		}

		return findParent(parent[vertex].parent);
	}
}
