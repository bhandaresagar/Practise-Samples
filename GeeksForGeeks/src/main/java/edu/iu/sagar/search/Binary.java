package edu.iu.sagar.search;

public class Binary extends SearchBase
{

	@Override
	public int search(int[] numbers, int key)
	{
		return binarySearch(numbers, key, 0, numbers.length - 1);
	}

	public int binarySearch(int[] numbers, int key, int left, int right)
	{

		if (left == right && numbers[left] != key)
		{
			return -1;
		}

		int mid = (left + right) / 2;

		if (numbers[mid] == key)
		{
			return mid;
		}

		int res = -1;

		if (numbers[mid] < key)
		{
			res = binarySearch(numbers, key, mid + 1, right);
		} else
		{
			res = binarySearch(numbers, key, left, mid);
		}

		return res;
	}

}
