package com.ilsoft.funnycreatures.core;

public enum Suffix
{
	EV("ев"),
	OV("ов"),
	CH("ч"),
	K("к"),
	N("н"),
	YAN("ян"),
	AT("ат");
	
	private String s;
	private Suffix(String s)
	{
		this.s = s;
	}
	
	public String getS() 
	{
		return s;
	}
}
