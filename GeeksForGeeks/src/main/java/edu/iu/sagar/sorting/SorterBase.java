package edu.iu.sagar.sorting;

public abstract class SorterBase
{
	public abstract void sort(int[] numbers);

	public void display(int[] numbers)
	{
		System.out.println();
		for (int i = 0; i < numbers.length; i++)
		{
			System.out.print(numbers[i] + " ");
		}
	}

	public static void main(String[] args)
	{
		int[] numbers = { -1, 3, 3, 2, 1, 6, -1, -7, -7 };
		SorterBase base = null;
		// base = new BubbleSort();
		// base = new InsertionSort();
		// base = new SelectionSort();
		// base = new ShellSort();
		// base = new MergeSortForArray();
		base = new QuickSort();
		// base = new HeapSort();
		base.display(numbers);
		base.sort(numbers);
		base.display(numbers);
	}

	public void swap(int[] array, int source, int dest)
	{
		int temp = array[source];
		array[source] = array[dest];
		array[dest] = temp;
	}
}
