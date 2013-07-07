package com.ilsoft.funnycreatures.core;

import com.ilsoft.funnycreatures.core.NounBase.Gender;

public class AdjectiveBase
{
	/**
	 * "ый", "ого", "ому", "ого", "ым", "ом"
	 * "ая", "ой", "ой", "ую", "ой", "ой"
	 */
	public static final AdjectiveBase HARD = new AdjectiveBase(
		new String[]
		{
			"ый", "ого", "ому", "ого", "ым", "ом"
		},
		new String[]
		{
			"ая", "ой", "ой", "ую", "ой", "ой"
		}
	);
	
	/**
	 * "ий", "ого", "ому", "ого", "им", "ом",
	 * "ая", "ую", "ой", "ую", "ой", "ой",
	 */
	public static final AdjectiveBase SOFT = new AdjectiveBase(
		new String[]
		{
			"ий", "ого", "ому", "ого", "им", "ом",
		},
		new String[]
		{
			"ая", "ую", "ой", "ую", "ой", "ой",
		}
	);
				
	/**
	 * "ой", "ого", "ому", "ого", "ым", "ом"
	 * "ая", "ой", "ой", "ую", "ой", "ой"
	 */
	public static final AdjectiveBase OLD = new AdjectiveBase(
		new String[]
		{
			"ой", "ого", "ому", "ого", "ым", "ом"
		},
		new String[]
		{
			"ая", "ой", "ой", "ую", "ой", "ой"
		}
	);	
	

	private String[] maleForms;
	private String[] femaleForms;

	public AdjectiveBase(AdjectiveBase other)
	{
		this.maleForms = other.maleForms.clone();
		this.femaleForms = other.femaleForms.clone();
	}
	
	/**
	 * Six forms for male cases, six for female cases
	 * @param maleForms
	 * @param femaleForms
	 */
	public AdjectiveBase(String[] maleForms, String[] femaleForms)
	{
		this.maleForms = maleForms.clone();
		this.femaleForms = femaleForms.clone();
	}

	public String getMaleForm(Case acase) 
	{
		return maleForms[acase.getIndex()];
	}

	public String getFemaleForm(Case acase) 
	{
		return femaleForms[acase.getIndex()];
	}
	
	public String getForm(Gender gender, Case acase)
	{
		if (gender == Gender.Male)
			return getMaleForm(acase);
		else
			return getFemaleForm(acase);
	}

	protected AdjectiveBase getEnding()
	{
		return this;
	}
	
	protected AdjectiveBase getBaseAdjective()
	{
		return null;
	}
}
