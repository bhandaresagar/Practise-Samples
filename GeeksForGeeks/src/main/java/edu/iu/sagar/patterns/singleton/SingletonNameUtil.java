package edu.iu.sagar.patterns.singleton;

public class SingletonNameUtil
{
	private String name;

	private static volatile SingletonNameUtil singletonNameUtil = null;

	private SingletonNameUtil()
	{
		if (singletonNameUtil != null)
		{
			throw new IllegalStateException("Class instantiated");
		}
	}

	public static SingletonNameUtil getInstance()
	{
		if (singletonNameUtil == null)
		{
			synchronized (SingletonNameUtil.class)
			{
				if (singletonNameUtil == null)
				{
					singletonNameUtil = new SingletonNameUtil();
				}
			}
		}

		return singletonNameUtil;
	}

	public String getName()
	{
		return this.name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

}
