package edu.iu.sagar.patterns.di;

public class DIdemo
{
	public static void main(String[] args)
	{
		Dependency dependency = new Dependency();
		dependency.setName("test");
		
		DependencyInjection injection = new DependencyInjection();
		injection.setDependency(dependency);
		injection.test();
	}
}
