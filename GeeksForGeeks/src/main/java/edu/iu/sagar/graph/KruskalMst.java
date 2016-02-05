package edu.iu.sagar.graph;

import java.util.Arrays;

public class KruskalMst
{
	public void getMst(Graph graph)
	{
		LoopDetector loopDetector = new PathCompressionLoopDetector();
		System.out.println(loopDetector.hasLoop(graph));
		
		// list of all edges of graph
		Edge[] edges = graph.edges;

		// sort the edges in increasing order of weights
		Arrays.sort(edges);

		int totalVertices = graph.V - 1;

		Graph graph2 = new Graph(totalVertices + 1, totalVertices);

		Edge[] mst = graph2.edges;

		int edgeIndex = 0;

		// MST has V - 1 edges
		for (int i = 0; i < graph.V - 1; i++)
		{
			// pick the edge with least weight
			Edge edge = edges[edgeIndex];

			// add to graph
			mst[i] = edge;

			// if it creates cycle, move to next edge
			while (loopDetector.hasLoop(graph2))
			{
				mst[i] = null;
				edgeIndex++;

				if (edgeIndex >= graph.E -1)
				{
					System.out.println("No mst");
					break;
				}

				edge = edges[edgeIndex];
				mst[i] = edge;
			}

			edgeIndex++;
		}

		graph.edges = graph2.edges;
		graph.E = graph2.E;
	}

	public static void main(String[] args)
	{
		KruskalMst mst = new KruskalMst();
		Graph graph = Graph.getDummyGraph();
		mst.getMst(graph);
		System.out.println(graph);
	}
}
