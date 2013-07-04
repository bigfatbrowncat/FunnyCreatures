package com.ilsoft.funnycreatures.core;

public class Root
{
	public enum RootLink
	{
		O("о"), E("e"), EMPTY("");
		
		private String s;
		private RootLink(String s)
		{
			this.s = s;
		}

		public String getS() 
		{
			return s;
		}
	}
	
	private String s;
	protected RootLink link;
	
	public Root(String s, RootLink link)
	{
		this.s = s;
		this.link = link;
	}

	public Root(Root root)
	{
		this.s = root.s;
		this.link = root.link;
	}

	public String getS()
	{
		return s;
	}
	
	public String getSWithLink()
	{
		return s + link.getS();
	}
	
	protected Root getRootBase()
	{
		return this;
	}
}
