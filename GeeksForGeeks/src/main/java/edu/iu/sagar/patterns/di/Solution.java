package edu.iu.sagar.patterns.di;

class Solution
{
	public int solution()
	{
		int X = 7, D = 3;
		int[] A = {1,5,1,2,1,4};
		// write your code in Java SE 8

		int minTime = 0;

		if (X - D <= 0)
		{
			return minTime;
		}

		if (X - A[0] - D <= 0)
		{
			return minTime;
		}

		int range = D, currentPos = 0;

		// add to covered distance hops that frog can take
		for (int i = 0; i < A.length; i++)
		{
			if (range >= X)
			{
				return i;
			}
			
			if (A[i] <= range && A[i] > currentPos)
			{
				currentPos = A[i];
				range = currentPos + D;

				if (range >= X)
				{
					return i;
				}

				boolean pathBlocked = false;

				while (!pathBlocked)
				{
					boolean newPath = false;
					for (int j = 0; j < i; j++)
					{
						if (A[j] > currentPos && A[j] <= range)
						{
							currentPos = A[j];
							range = currentPos + A[j];
							newPath = true;
						}
					}
					
					if(!newPath)
					{
						pathBlocked = true;
					}
				}

			}
		}

		return -1;
	}
	
	public static void main(String[] args)
	{
		Solution solution = new Solution();
		System.out.println(solution.solution());
	}
}