package com.ilsoft.funnycreatures.core.species;

import com.ilsoft.funnycreatures.core.Adjective;
import com.ilsoft.funnycreatures.core.Case;
import com.ilsoft.funnycreatures.core.Noun;

public class SpeciesName
{
	private Adjective[] adjectives;
	private Noun noun;

	public SpeciesName(Adjective[] adjectives, Noun noun)
	{
		this.adjectives = adjectives;
		this.noun = noun;
	}

	public String getFullName(Case acase)
	{
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < adjectives.length; i++)
		{
			sb.append(adjectives[i].getForm(noun.getGender(), acase));
			sb.append(" ");
		}

		sb.append(noun.getForm(acase));
		
		return sb.toString();
	}
	
	public Noun getNoun()
	{
		return noun;
	}

	public Adjective[] getAdjectives()
	{
		return adjectives;
	}
	
}
