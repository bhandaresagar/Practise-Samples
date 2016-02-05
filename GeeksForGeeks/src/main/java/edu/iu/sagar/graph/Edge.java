package edu.iu.sagar.graph;

public class Edge implements Comparable<Edge>
{
	// source destination and weight
	int src, dest, weight;

	public Edge(int src, int dest, int weight)
	{
		super();
		this.src = src;
		this.dest = dest;
		this.weight = weight;
	}

	public Edge()
	{
	}

	@Override
	public int compareTo(Edge o)
	{
		return this.weight - o.weight;
	}

	@Override
	public String toString()
	{
		return "Edge [src=" + this.src + ", dest=" + this.dest + ", weight=" + this.weight + "]";
	}

}
