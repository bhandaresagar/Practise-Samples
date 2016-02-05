package edu.iu.sagar.sorting;

public class MergeSortArray
{

	public void sort(int[] array)
	{
		partition(0, array.length - 1, array);
	}

	private void partition(int low, int high, int[] array)
	{
		if (low >=  high)
		{
			return;
		}
		
		int mid = (low + high) / 2;
		partition(low, mid, array);
		partition(mid + 1, high, array);
		merge(low, high, array, mid);

	}

	private void merge(int low, int high, int[] array, int mid)
	{
		int[] temp = new int[high - low + 1];

		int lptr = low, rptr = mid + 1, index = 0;

		while (lptr <= mid && rptr <= high)
		{
			if (array[lptr] < array[rptr])
			{
				temp[index++] = array[lptr++];
			} else
			{
				temp[index++] = array[rptr++];
			}
		}

		while (lptr <= mid)
		{	
			temp[index++] = array[lptr++];
		}

		while (rptr <= high)
		{
			temp[index++] = array[rptr++];
		}

		// copy to original
		for (int i = 0; i < index; i++)
		{
			array[low + i] = temp[i];
		}
	}

	public static void display(int[] numbers)
	{
		System.out.println();
		for (int i = 0; i < numbers.length; i++)
		{
			System.out.print(numbers[i] + " ");
		}
	}
	
	public static void main(String[] args)
	{
		MergeSortArray sortArray = new MergeSortArray();
		int [] array = new int[] { 5, 3, 2, 4, 1, 6, 8 };
		sortArray.sort(array);
		display(array);
	}
}
