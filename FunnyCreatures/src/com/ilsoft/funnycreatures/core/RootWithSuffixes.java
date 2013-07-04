package com.ilsoft.funnycreatures.core;

public class RootWithSuffixes extends Root
{
	private Root baseRoot;
	private Suffix suffix;
	
	public RootWithSuffixes(Root baseRoot, Suffix suffix, RootLink link)
	{
		super(baseRoot.getRootBase());
		this.baseRoot = baseRoot;
		this.suffix = suffix;
		this.link = link;
	}
	
	protected Root getRootBase() 
	{
		return super.getRootBase();
	}
	
	@Override
	public String getS() 
	{
		return baseRoot.getS() + suffix.getS();
	}
}
