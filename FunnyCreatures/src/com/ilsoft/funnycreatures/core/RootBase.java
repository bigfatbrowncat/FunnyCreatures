package com.ilsoft.funnycreatures.core;

public class RootBase
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
	
	private int id;
	private String s;
	protected RootLink link;
	
	public RootBase(int id, String s, RootLink link)
	{
		this.id = id;
		this.s = s;
		this.link = link;
	}

	public RootBase(RootBase root)
	{
		this.id = root.id;
		this.s = root.s;
		this.link = root.link;
	}

	public int getId() {
		return id;
	}

	public String getS()
	{
		return s;
	}
	
	public String getSWithLink()
	{
		return s + link.getS();
	}
	
	protected RootBase getRootBase()
	{
		return this;
	}
}
