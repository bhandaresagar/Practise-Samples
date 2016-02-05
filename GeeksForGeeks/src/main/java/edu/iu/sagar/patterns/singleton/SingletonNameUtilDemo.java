package edu.iu.sagar.patterns.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class SingletonNameUtilDemo
{
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException
	{
		SingletonNameUtil nameUtil = SingletonNameUtil.getInstance();
		nameUtil.setName("sagar");
		
		SingletonNameUtil nameUtil1 = SingletonNameUtil.getInstance();
		System.out.println(nameUtil1.getName());
		
		/*Constructor<?> util = Class.forName("edu.iu.sagar.patterns.singleton.SingletonNameUtil").getDeclaredConstructor();
		util.setAccessible(true);
		
		SingletonNameUtil nameUtil2 = (SingletonNameUtil) util.newInstance(null);
		nameUtil2.setName("abc");
		System.out.println(nameUtil2.getName());*/
	}

}
