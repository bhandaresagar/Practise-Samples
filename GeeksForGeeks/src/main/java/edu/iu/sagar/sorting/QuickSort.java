package edu.iu.sagar.sorting;

public class QuickSort extends SorterBase
{
	@Override
	public void sort(int[] numbers)
	{
		partition(numbers, 0, numbers.length - 1);
	}

	public void partition(int[] numbers, int left, int right)
	{
		int lpos = left, rpos = right;

		if (left < right)
		{
			int pivot = numbers[left];

			while (left < right)
			{
				while (numbers[left] < pivot)
					left++;
				while (numbers[right] > pivot)
					right--;

				if (left <= right)
				{
					swap(numbers, left, right);
					left++;
					right--;
				}
			}

			partition(numbers, lpos, right - 1);
			partition(numbers, left + 1, rpos);
		}
	}
}
