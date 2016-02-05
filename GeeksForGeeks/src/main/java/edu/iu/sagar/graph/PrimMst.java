package edu.iu.sagar.graph;

public class PrimMst
{
	class PrimVertex implements Comparable<PrimVertex>
	{
		int vertex;
		int cost;

		public PrimVertex(int vertex, int cost)
		{
			super();
			this.vertex = vertex;
			this.cost = cost;
		}

		@Override
		public int compareTo(PrimVertex o)
		{
			return this.cost - o.cost;
		}
	}

	public void getMst(Graph graph)
	{

	}

}
