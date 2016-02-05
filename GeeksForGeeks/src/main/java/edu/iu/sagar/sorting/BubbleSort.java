package edu.iu.sagar.sorting;

public class BubbleSort extends SorterBase
{
	public void sort(int[] numbers)
	{
		for (int i = 0; i < numbers.length - 1; i++)
		{
			for (int j = i + 1; j > 0; j--)
			{
				if (numbers[j - 1] > numbers[j])
				{
					int temp = numbers[j];
					numbers[j] = numbers[j - 1];
					numbers[j - 1] = temp;
				}
			}
		}
	}

	public void sort2(int[] numbers)
	{
		boolean swap = false;

		do
		{
			swap = false;
			for (int j = 1; j < numbers.length - 1; j++)
			{
				if (numbers[j - 1] > numbers[j])
				{
					int temp = numbers[j];
					numbers[j] = numbers[j - 1];
					numbers[j - 1] = temp;
					swap = true;
				}
			}
		} while (swap);
	}

}
