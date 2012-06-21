package com.ilsoft.funnycreatures.core;

public class RootWithSuffixes extends RootBase
{
	private RootBase baseRoot;
	private Suffix suffix;
	
	public RootWithSuffixes(RootBase baseRoot, Suffix suffix, RootLink link)
	{
		super(baseRoot.getRootBase());
		this.baseRoot = baseRoot;
		this.suffix = suffix;
		this.link = link;
	}
	
	protected RootBase getRootBase() 
	{
		return super.getRootBase();
	}
	
	@Override
	public String getS() 
	{
		return baseRoot.getS() + suffix.getS();
	}
}
