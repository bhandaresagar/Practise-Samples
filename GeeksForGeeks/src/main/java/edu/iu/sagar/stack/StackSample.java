package edu.iu.sagar.stack;

public class StackSample
{
	public static void main(String[] args)
	{
		ArrayStack<Integer> arrayStack = new ArrayStack<Integer>();

		System.out.print("Push: ");
		for (int i = 0; i < 10; i++)
		{
			arrayStack.push(i);
			System.out.print(i + ", ");
		}
		System.out.print("\nPOP: ");

		for (int i = 0; i < 10; i++)
		{
			System.out.print(arrayStack.pop() + ", ");
		}

		LinkedStack<Character> linkedStack = new LinkedStack<Character>();

		String name = "sagar";
		System.out.print("\n\nPush: " + name);
		
		for (char c : name.toCharArray())
		{
			linkedStack.push(c);
		}

		System.out.print("\nPOP: ");

		for (int i = 0; i < name.length(); i++)
		{
			System.out.print(linkedStack.pop() + ", ");
		}

	}
}
