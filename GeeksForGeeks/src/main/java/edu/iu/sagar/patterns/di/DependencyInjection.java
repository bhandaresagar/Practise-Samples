package edu.iu.sagar.patterns.di;

public class DependencyInjection
{
	private Dependency dependency;

	public Dependency getDependency()
	{
		return this.dependency;
	}

	public void setDependency(Dependency dependency)
	{
		this.dependency = dependency;
	}
	
	public void test()
	{
		System.out.println(dependency.getName());
	}

}
