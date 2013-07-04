package com.ilsoft.funnycreatures.core;

import java.util.ArrayList;

public class Noun extends NounBase
{
	private Root root;
	private NounBase baseNoun;
	
	public Noun(Root rootBase, NounBase nounBase)
	{
		super(nounBase);
		this.baseNoun = nounBase;
		this.root = rootBase;
	}

	public String getForm(Case acase) 
	{
		String res;
		if (baseNoun.getBaseNoun() == null)
		{
			res = root.getS();
		}
		else
		{
			res = root.getSWithLink();
		}
		
		res += baseNoun.getForm(acase);
		
		return res;
	}

	@Override
	protected NounBase getBaseNoun()
	{
		return baseNoun;
	}
	
	public Root getRoot()
	{
		return root;
	}
	
	public Root[] getRoots()
	{
		ArrayList<Root> roots = new ArrayList<Root>();
		NounBase nb = this;
		do
		{
			roots.add(0, ((Noun)nb).getRoot());
			nb = nb.getBaseNoun();
		}
		while (nb instanceof Noun);
		
		return roots.toArray(new Root[] {});
	}
}
