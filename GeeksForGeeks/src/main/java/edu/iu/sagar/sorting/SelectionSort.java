package edu.iu.sagar.sorting;

public class SelectionSort extends SorterBase
{
	public void sort(int[] numbers)
	{
		for (int i = 0; i < numbers.length - 1; i++)
		{
			int min = numbers[i], minPos = -1;

			for (int j = i + 1; j < numbers.length; j++)
			{
				if (numbers[j] < min)
				{
					min = numbers[j];
					minPos = j;
				}
			}

			if (minPos != -1)
			{
				swap(numbers, i, minPos);
			}
		}
	}
}
