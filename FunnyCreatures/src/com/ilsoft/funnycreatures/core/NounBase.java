package com.ilsoft.funnycreatures.core;

public class NounBase
{
	public static final NounBase F_HARD_1 = new NounBase
	(
		Gender.Female,
		new String[]
		{
			"а", "и", "е", "у", "ой", "е"
		}
	);
	public static final NounBase F_SOFT_1 = new NounBase
	(
		Gender.Female,
		new String[]
		{
			"я", "и", "е", "ю", "ей", "е"
		}
	);

	public static final NounBase M_HARD_1 = new NounBase
	(
		Gender.Male,
		new String[]
		{
			"", "а", "у", "а", "ом", "е"
		}
	);

	public static final NounBase M_SOFT_1 = new NounBase
	(
		Gender.Male,
		new String[]
		{
			"й", "я", "ю", "й", "ем", "е"
		}
	);
	
	public static final NounBase M_2 = new NounBase
	(
		Gender.Male,
		new String[]
		{
			"ень", "ня", "ню", "ня", "нем", "не"
		}
	);
	
	public enum Gender { Male, Female }

	private String[] forms;
	private Gender gender;
	
	public NounBase(Gender gender, String[] forms)
	{
		this.forms = forms;
		this.gender = gender;
	}
	
	protected NounBase(NounBase nounBase)
	{
		forms = nounBase.forms;
		gender = nounBase.gender;
	}
	
	public String getForm(Case acase)
	{
		return forms[acase.getIndex()];
	}
	
	public Gender getGender() 
	{
		return gender;
	}
	
	protected NounBase getBaseNoun()
	{
		return null;
	}
}
