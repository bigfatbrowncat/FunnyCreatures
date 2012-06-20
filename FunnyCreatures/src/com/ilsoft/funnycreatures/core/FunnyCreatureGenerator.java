package com.ilsoft.funnycreatures.core;

import java.util.ArrayList;
import java.util.Random;

public class FunnyCreatureGenerator
{
	private static IdPair[] bannedPairs = new IdPair[]
	{
		// Единственная часть тела по умолчанию
		new IdPair(201, 100),
		new IdPair(201, 104),
		new IdPair(201, 105),
		new IdPair(201, 106),
		new IdPair(201, 108),
		new IdPair(201, 109),
		new IdPair(201, 110),

		// Четвероногий - это скучно
		new IdPair(204, 102),

		// Слишком много про шерсть
		new IdPair(409, 513),
		
		// Тавтологии с лапами
		new IdPair(102, 103),	// лаполапчатый 
		new IdPair(103, 102),	// лапчатолапый
		
	};
	
	private static boolean isBanned(Integer[] ids)
	{
		for (int i = 0; i < ids.length - 1; i++)
		for (int j = i + 1; j < ids.length; j++)
		{
			// Equal IDs are not allowed
			if (ids[i].equals(ids[j])) return true;
		}
		
		// Checking for banned pairs
		for (int i = 0; i < ids.length - 1; i++)
		{
			// Checking if it's banned
			for (int k = 0; k < bannedPairs.length; k++)
			{
				if (bannedPairs[k].getId1() == ids[i] && bannedPairs[k].getId2() == ids[i + 1])
				{
					return true;
				}
			}
			
		}
		
		return false;
	}
	
	public static FunnyCreature generate(Random rnd)
	{
		ArrayList<Integer> indexes = new ArrayList<Integer>();

		int adjectivesNumber = rnd.nextInt(2) + 1;
		
		boolean[] adjectiveIsCompound = new boolean[adjectivesNumber];
		for (int i = 0; i < adjectivesNumber; i++)
		{
			adjectiveIsCompound[i] = rnd.nextBoolean();
		}
		
		boolean nounIsCompound = rnd.nextBoolean();
		
		FunnyCreature generatedCreature = null;
		do
		{
			indexes.clear();
			
			for (int i = 0; i < adjectivesNumber; i++)
			{
				if (adjectiveIsCompound[i])
				{
					// Generating first adjective root
					indexes.add(rnd.nextInt(FunnyCreature.firstRootParts.length));
					
					// Generating the last adjective root
					indexes.add(rnd.nextInt(FunnyCreature.lastAdjectiveParts.length));
				}
				else
				{
					indexes.add(rnd.nextInt(FunnyCreature.singlePartAdjectives.length));
				}
			}
			
			if  (nounIsCompound)
			{
				// Generating first noun root
				indexes.add(rnd.nextInt(FunnyCreature.firstRootParts.length));
	
				// Generating the last noun root
				indexes.add(rnd.nextInt(FunnyCreature.lastNounParts.length));
			}
			else
			{
				indexes.add(rnd.nextInt(FunnyCreature.singlePartNoun.length));
			}

			generatedCreature = new FunnyCreature(adjectivesNumber, nounIsCompound, adjectiveIsCompound, indexes.toArray(new Integer[] {}));
		}
		while (isBanned(generatedCreature.getIds()));
		
		return generatedCreature;
	}

}
