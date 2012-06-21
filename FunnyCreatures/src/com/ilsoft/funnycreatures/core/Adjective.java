package com.ilsoft.funnycreatures.core;

import com.ilsoft.funnycreatures.core.NounBase.Gender;

public class Adjective extends AdjectiveBase
{
	private RootBase root;
	private AdjectiveBase baseAdjective = null;

	@Override
	public AdjectiveBase getEnding()
	{
		return super.getEnding();
	}
	
	/**
	 * Six forms for male and female
	 */
	public Adjective(RootBase root, AdjectiveBase baseAdjective)
	{
		super(baseAdjective.getEnding());
		this.root = root;
		this.baseAdjective = baseAdjective;
	}

	public String getMaleForm(Case acase) 
	{
		String res;
		if (baseAdjective.getBaseAdjective() == null)
		{
			res = root.getS();
		}
		else
		{
			res = root.getSWithLink();
		}

		res += baseAdjective.getMaleForm(acase);
		
		return res;
	}

	public String getFemaleForm(Case acase) 
	{
		String res;
		if (baseAdjective.getBaseAdjective() == null)
		{
			res = root.getS();
		}
		else
		{
			res = root.getSWithLink();
		}

		res += baseAdjective.getFemaleForm(acase);
		
		return res;
	}

	public final String getForm(Gender gender, Case acase)
	{
		if (gender == Gender.Male)
			return getMaleForm(acase);
		else
			return getFemaleForm(acase);
	}
	
	public RootBase getRoot()
	{
		return root;
	}

	protected AdjectiveBase getBaseAdjective()
	{
		return baseAdjective;
	}
	
}
