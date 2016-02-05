package edu.iu.sagar.sorting;

public class InsertionSort extends SorterBase
{
	public void sort(int[] numbers)
	{
		for (int i = 0; i < numbers.length - 1; i++)
		{
			int key = numbers[i];

			for (int j = i + 1; j > 0 && numbers[j] < key; j--)
			{
				int temp = numbers[j - 1];
				numbers[j - 1] = numbers[j];
				numbers[j] = temp;
			}
		}
	}

}
