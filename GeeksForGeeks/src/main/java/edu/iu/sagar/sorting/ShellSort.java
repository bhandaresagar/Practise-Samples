package edu.iu.sagar.sorting;

public class ShellSort extends SorterBase
{
	public void sort(int[] numbers)
	{

		int increment = numbers.length / 2, total = numbers.length - 1, j;

		while (increment > 0)
		{
			for (int i = increment; i < total; i++)
			{
				int temp = numbers[i];

				for (j = i; j >= increment; j -= increment)
				{
					if (temp < numbers[j - increment])
					{
						numbers[j] = numbers[j - increment];
					} else
					{
						break;
					}
				}

				numbers[j] = temp;
			}

			increment /= 2;
		}
	}
}
