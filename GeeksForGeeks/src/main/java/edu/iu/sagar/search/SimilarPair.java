package edu.iu.sagar.search;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SimilarPair
{

	static Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	static int similarPairs = 0;

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);

		int totalRows = sc.nextInt();
		int T = sc.nextInt();

		for (int i = 0; i < totalRows - 1; i++)
		{
			int data = sc.nextInt();
			int cdata = sc.nextInt();
			int currValue = cdata;

			map.put(cdata, data);

			while (map.get(cdata) != null)
			{

				int parent = map.get(cdata);

				if (Math.abs(parent - currValue) <= T)
				{
					similarPairs += 1;
				}

				cdata = parent;
			}
		}

		System.out.println(similarPairs);
		sc.close();
	}
}