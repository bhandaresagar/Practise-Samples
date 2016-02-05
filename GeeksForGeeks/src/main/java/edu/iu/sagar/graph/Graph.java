package edu.iu.sagar.graph;

import java.util.Arrays;

public class Graph
{
	// number of vertices and edges
	int V, E;

	// set of edges
	Edge[] edges;

	public Graph(int v, int e)
	{
		this.V = v;
		this.E = e;
		this.edges = new Edge[e];
	}

	public static Graph getDummyGraph()
	{
		Graph graph = new Graph(9, 14);

		graph.edges[0] = new Edge(7, 6, 1);
		graph.edges[1] = new Edge(8, 2, 2);
		graph.edges[2] = new Edge(6, 5, 2);
		graph.edges[3] = new Edge(0, 1, 4);
		graph.edges[4] = new Edge(2, 5, 4);
		graph.edges[5] = new Edge(8, 6, 6);
		graph.edges[6] = new Edge(2, 3, 7);
		graph.edges[7] = new Edge(7, 8, 7);
		graph.edges[8] = new Edge(0, 7, 8);
		graph.edges[9] = new Edge(1, 2, 8);
		graph.edges[10] = new Edge(3, 4, 9);
		graph.edges[11] = new Edge(5, 4, 10);
		graph.edges[12] = new Edge(1, 7, 11);
		graph.edges[13] = new Edge(3, 5, 14);

		return graph;
	}

	@Override
	public String toString()
	{
		return "Graph [V=" + this.V + ", E=" + this.E + ", edges=" + Arrays.toString(this.edges)
				+ "]";
	}

	public static void main(String[] args)
	{
		Graph graph = Graph.getDummyGraph();
	}
}
