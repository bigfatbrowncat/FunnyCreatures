package com.ilsoft.funnycreatures.core;

import com.ilsoft.funnycreatures.core.Noun.Gender;

public class Adjective
{
	private int id;
	private String maleForm;
	private String femaleForm;
	
	public Adjective(int id, String maleForm, String femaleForm)
	{
		this.id = id;
		this.maleForm = maleForm;
		this.femaleForm = femaleForm;
	}

	public int getId() {
		return id;
	}

	public String getMaleForm() 
	{
		return maleForm;
	}

	public String getFemaleForm() 
	{
		return femaleForm;
	}
	
	public String getForm(Gender gender)
	{
		if (gender == Gender.Male)
			return getMaleForm();
		else
			return getFemaleForm();
	}
}
