package edu.iu.sagar.sorting;

public class HeapSort extends SorterBase
{

	@Override
	public void sort(int[] numbers)
	{
		int total = numbers.length - 1;

		for (int i = total / 2; i >= 0; i--)
		{
			heapify(numbers, i, total);
		}

		for (int i = total; i >= 0; i--)
		{
			swap(numbers, i, 0);
			heapify(numbers, 0, --total);
		}

	}

	public void heapify(int[] numbers, int i, int total)
	{
		int largest = numbers[i];
		int child = 2 * i + 1;
		boolean swap = false;

		if (child <= total && getLeftChild(numbers, i) > largest)
		{
			swap = true;
		}

		int temp = 2 * i + 2;
		if (temp <= total && getRightChild(numbers, i) > getLeftChild(numbers, i)
				&& getRightChild(numbers, i) > largest)
		{
			swap = true;
			child = temp;
		}
		if (swap)
		{
			swap(numbers, i, child);
			heapify(numbers, child, total);
		}
	}

	public int getLeftChild(int[] numbers, int root)
	{
		return numbers[2 * root + 1];
	}

	public int getRightChild(int[] numbers, int root)
	{
		return numbers[2 * root + 2];
	}

}
