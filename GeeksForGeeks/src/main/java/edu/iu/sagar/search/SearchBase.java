package edu.iu.sagar.search;

import edu.iu.sagar.sorting.QuickSort;
import edu.iu.sagar.sorting.SorterBase;

public abstract class SearchBase
{
	public abstract int search(int[] numbers, int key);

	public static void main(String[] args)
	{
		int[] numbers = { -1, 3, 3, 2, 1, 6, -1, -7, -7 };

		SorterBase sorter = new QuickSort();
		sorter.sort(numbers);
		sorter.display(numbers);
		SearchBase base = new Binary();
		System.out.println(base.search(numbers, 3));
	}
}
