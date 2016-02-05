package edu.iu.sagar.google;

import java.util.HashMap;
import java.util.Map;

public class PiratesOfCaribbean
{
	public static int getLoop(int[] numbers)
	{
		int piratesVisitedSoFar = 0;
		
		//Holds piarate's number and number of pirates visited before meeting him
		Map<Integer, Integer> visitMap = new HashMap<Integer, Integer>();

		int pirateNumber = 0;

		while (piratesVisitedSoFar <= numbers.length)
		{
			//have we visited this pirate before?
			if (visitMap.containsKey(pirateNumber))
			{
				//yes we have, subtract number of pirates visited before start of loop
				piratesVisitedSoFar -= visitMap.get(pirateNumber);
				break;
			}
			else
			{
				//add current pirate and count of pirates visited till now to the map
				visitMap.put(pirateNumber, piratesVisitedSoFar);
				piratesVisitedSoFar++;
			}
			
			//redirect to new pirate
			pirateNumber = numbers[pirateNumber];
		}
 
		return piratesVisitedSoFar;
	}

	public static int getLoopCount(int[] numbers)
	{
		//tortoise and hare algorithm based implementation to detect loop
		boolean loop = false;
		int fast = 0;
		int slow = 0;
		int count = 0;
		while (slow < numbers.length && fast < numbers.length)
		{
			slow = numbers[slow];
			fast = numbers[numbers[fast]];
			if (slow == fast)
			{
				loop = true;
				count = 1;
				break;
			}
		}
		while (loop)
		{
			slow = numbers[slow];
			fast = numbers[numbers[fast]];
			if (slow == fast)
			{
				break;
			}
			count++;
		}
		return count;
	}

	public static void main(String[] args)
	{
		int arr[] = { 1, 3, 0, 2 };
		System.out.println(getLoop(arr));
	}

}
