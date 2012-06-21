package com.ilsoft.funnycreatures.core;

public enum Case
{
	NOMINATIVE(0),
	GENITIVE(1),
	DATIVE(2),
	ACCUSATIVE(3),
	ABLATIVE(4),
	PREPOSITIVE(5);
	
	private int index;
	
	Case(int index)
	{ 
		this.index = index; 
	}
	public int getIndex() 
	{
		return index;
	}
}