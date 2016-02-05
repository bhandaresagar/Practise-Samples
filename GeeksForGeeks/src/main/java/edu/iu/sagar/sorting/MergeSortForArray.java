package edu.iu.sagar.sorting;

public class MergeSortForArray extends SorterBase
{

	@Override
	public void sort(int[] numbers)
	{
		mergeSort(numbers, 0, numbers.length - 1);
	}

	public void mergeSort(int[] numbers, int left, int right)
	{
		if (left < right)
		{
			int mid = (left + right) / 2;
			mergeSort(numbers, left, mid);
			mergeSort(numbers, mid + 1, right);
			merge(left, right, numbers, mid);
		}
	}

	public void merge(int left, int right, int[] numbers, int mid)
	{
		int[] temp = new int[right - left + 1];
		int lpos = left, index = 0, rpos = mid + 1;

		while (lpos <= mid && rpos <= right)
		{
			if (numbers[lpos] < numbers[rpos])
			{
				temp[index] = numbers[lpos];
				lpos++;
			} else
			{
				temp[index] = numbers[rpos];
				rpos++;
			}
			index++;
		}

		while (lpos <= mid)
		{
			temp[index] = numbers[lpos];
			index++;
			lpos++;
		}
		while (rpos <= right)
		{
			temp[index] = numbers[rpos];
			index++;
			rpos++;
		}

		// copy to original
		for (int i = 0; i < index; i++)
		{
			numbers[i + left] = temp[i];
			
		}
		return;
	}

}
