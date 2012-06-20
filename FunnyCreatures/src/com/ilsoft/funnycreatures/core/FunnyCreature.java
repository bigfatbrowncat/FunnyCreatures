package com.ilsoft.funnycreatures.core;

import java.util.ArrayList;

import com.ilsoft.funnycreatures.core.Noun.Gender;

public class FunnyCreature
{
	private int adjectivesNumber;
	private boolean nounIsCompound;
	private boolean[] adjectiveIsCompound;
	private Integer[] indexes;
	
	public static final Adjective[] singlePartAdjectives = new Adjective[]
	{
		new Adjective(3, "тигровый", "тигровая"),
		new Adjective(9, "ёжиковидный", "ёжиковидная"),
		
		new Adjective(103, "лапчатый", "лапчатая"),
		new Adjective(104, "мордастый", "мордастая"),
		new Adjective(106, "носатый", "носатая"),

		new Adjective(300, "граблеватый", "граблеватая"),
		new Adjective(301, "косоватый", "косоватая"),
		new Adjective(302, "шишковатый", "шишковатая"),
		new Adjective(303, "рогатый", "рогатая"),
		new Adjective(306, "полосатый", "полосатая"),
		new Adjective(307, "пятнистый", "пятнистая"),
		new Adjective(314, "продолговатый", "продолговатая"),
		new Adjective(319, "бледный", "бледная"),

		new Adjective(600, "обыкновенный", "обыкновенная"),
		new Adjective(601, "ложный", "ложная"),
		new Adjective(602, "пустынный", "пустынная"),
		new Adjective(603, "речной", "речная"),
		new Adjective(604, "лесной", "лесная"),
		new Adjective(605, "песчаный", "песчаная"),
		new Adjective(606, "подкустовый", "подкустовая"),
		new Adjective(607, "болотный", "болотная"),
		new Adjective(608, "травянистый", "травянистая"),
		new Adjective(609, "подкамневый", "подкамневая"),
	};
	
	public static final AdjectiveRoot[] firstRootParts = new AdjectiveRoot[]
	{
		// Животно
		new AdjectiveRoot(0, "кошко"),
		new AdjectiveRoot(1, "утко"),
		new AdjectiveRoot(2, "зайце"),
		new AdjectiveRoot(3, "тигро"),
		new AdjectiveRoot(4, "крысо"),
		new AdjectiveRoot(5, "медведе"),
		new AdjectiveRoot(6, "дятло"),
		new AdjectiveRoot(7, "тюлене"),
		new AdjectiveRoot(8, "слоно"),
		new AdjectiveRoot(9, "ёжико"),

		// Частетельно
		new AdjectiveRoot(100, "хвосто"),
		new AdjectiveRoot(101, "ухо"),
		new AdjectiveRoot(102, "лапо"),
		new AdjectiveRoot(103, "лапчато"),
		new AdjectiveRoot(104, "мордо"),
		new AdjectiveRoot(105, "задо"),
		new AdjectiveRoot(106, "носо"),
		new AdjectiveRoot(107, "крыло"),
		new AdjectiveRoot(109, "пузо"),
		new AdjectiveRoot(110, "клюво"),
		new AdjectiveRoot(111, "хобото"),
		new AdjectiveRoot(112, "ноздре"),
		new AdjectiveRoot(112, "клыкасто"),

		// Количественно
		new AdjectiveRoot(200, "без"),
		new AdjectiveRoot(201, "едино"),
		new AdjectiveRoot(202, "дву"),
		new AdjectiveRoot(203, "трёх"),
		new AdjectiveRoot(204, "четырех"),
		new AdjectiveRoot(205, "пяти"),
		
		// Внешне
		new AdjectiveRoot(300, "грабле"),
		new AdjectiveRoot(301, "косо"),
		new AdjectiveRoot(302, "шишко"),
		new AdjectiveRoot(303, "рого"),
		new AdjectiveRoot(304, "перепончато"),
		new AdjectiveRoot(305, "гладко"),
		new AdjectiveRoot(306, "полосато"),
		new AdjectiveRoot(307, "пятнисто"),
		new AdjectiveRoot(308, "тупо"),
		new AdjectiveRoot(309, "остро"),
		new AdjectiveRoot(310, "длинно"),
		new AdjectiveRoot(311, "коротко"),
		new AdjectiveRoot(312, "выпукло"),
		new AdjectiveRoot(313, "узко"),
		new AdjectiveRoot(314, "продолговато"),
		new AdjectiveRoot(315, "висло"),
		new AdjectiveRoot(316, "торчко"),
		new AdjectiveRoot(317, "быстро"),
		new AdjectiveRoot(318, "толсто"),
		new AdjectiveRoot(319, "бледно"),

		new AdjectiveRoot(409, "шерсте"),
		new AdjectiveRoot(411, "чешуйчато"),

		new AdjectiveRoot(600, "обыкновенно"),
		new AdjectiveRoot(601, "ложно"),
	};

	public static final  Adjective[] lastAdjectiveParts = new Adjective[]
	{
		// Частетельный
		new Adjective(100, "хвостый", "хвостая"),
		new Adjective(101, "ухий", "ухая"),
		new Adjective(102, "лапый", "лапая"),
		new Adjective(103, "лапчатый", "лапчатая"),
		new Adjective(104, "мордый", "мордая"),
		new Adjective(105, "задый", "задая"),
		new Adjective(106, "носый", "носая"),
		new Adjective(107, "крылый", "крылая"),
		new Adjective(108, "лобый", "лобая"),
		new Adjective(109, "пузый", "пузая"),
		new Adjective(110, "клювый", "клювая"),

		new Adjective(303, "рогий", "рогая"),
		
		
		// Внешний
		new Adjective(407, "шкурый", "шкурая"),
		new Adjective(408, "глазый", "глазая"),
		new Adjective(409, "шерстный", "шерстная"),
		new Adjective(410, "палый", "палая"),
	};

	public static final Noun[] singlePartNoun = new Noun[]
	{
		new Noun(500, "растопырка", Gender.Female),
		new Noun(501, "гребубля", Gender.Female),
		new Noun(502, "лупоглядень", Gender.Male),
		new Noun(503, "кусачка", Gender.Female),
		new Noun(504, "царапка", Gender.Female),
		new Noun(505, "выползень", Gender.Male),
		new Noun(506, "увалень", Gender.Male),
		new Noun(507, "невидень", Gender.Male),
		new Noun(508, "отгрызайка", Gender.Female),
		new Noun(509, "уползад", Gender.Male),
		new Noun(510, "грибоед", Gender.Male),
		new Noun(511, "камнегрыз", Gender.Male),
		new Noun(511, "древожуй", Gender.Male),
		new Noun(512, "тормозень", Gender.Male),
		new Noun(513, "шерстень", Gender.Male),
		new Noun(514, "злобнозырк", Gender.Male),
		new Noun(515, "откусучка", Gender.Female),
	};
	
	public static final Noun[] lastNounParts = new Noun[]
	{
		// Частетельный
		new Noun(100, "хвост", Gender.Male),
		new Noun(101, "ух", Gender.Male),
		new Noun(102, "лап", Gender.Male),
		new Noun(104, "морд", Gender.Male),
		new Noun(105, "зад", Gender.Male),
		new Noun(106, "нос", Gender.Male),
		new Noun(107, "крыл", Gender.Male),
		new Noun(109, "пуз", Gender.Male),
		new Noun(110, "клюв", Gender.Male),
		new Noun(112, "клык", Gender.Male),

		new Noun(303, "рога", Gender.Female),
		
		// Внешний
		new Noun(407, "шкур", Gender.Male),
		new Noun(408, "глаз", Gender.Male),
	};

	public int getAdjectivesNumber() {
		return adjectivesNumber;
	}

	public boolean isNounCompound() {
		return nounIsCompound;
	}

	public boolean[] getAdjectiveIsCompound() {
		return adjectiveIsCompound;
	}

	public Integer[] getIndexes() {
		return indexes;
	}

	public Integer[] getIds()
	{
		ArrayList<Integer> ids = new ArrayList<Integer>();
		int indexNumber = 0;
		
		for (int i = 0; i < adjectivesNumber; i++)
		{
			if (adjectiveIsCompound[i])
			{
				ids.add(firstRootParts[indexes[indexNumber]].getId());
				indexNumber++;
				ids.add(lastAdjectiveParts[indexes[indexNumber]].getId());
			}
			else
			{
				ids.add(singlePartAdjectives[indexes[indexNumber]].getId());
			}
			indexNumber++;
		}
		
		if (nounIsCompound)
		{
			ids.add(firstRootParts[indexes[indexNumber]].getId());
			indexNumber++;
			ids.add(lastNounParts[indexes[indexNumber]].getId());
		}
		else
		{
			ids.add(singlePartNoun[indexes[indexNumber]].getId());
		}
		indexNumber++;
		
		return ids.toArray(new Integer[] {});
	}

	public Gender getGender()
	{
		int partIndex = 0;
		
		for (int i = 0; i < adjectivesNumber; i++)
		{
			if (adjectiveIsCompound[i]) 
				partIndex += 2;
			else
				partIndex ++;
		}
		
		if (nounIsCompound) 
		{
			partIndex ++;
			return lastNounParts[indexes[partIndex]].getGender();
		}
		else
		{
			return singlePartNoun[indexes[partIndex]].getGender();
		}
	}
	
	/*
	 * If it's not single part, returns null
	 */
	public Noun getSinglePartNoun()
	{
		int partIndex = 0;
		
		for (int i = 0; i < adjectivesNumber; i++)
		{
			if (adjectiveIsCompound[i]) 
				partIndex += 2;
			else
				partIndex ++;
		}
			
		if (!nounIsCompound)
		{
			return singlePartNoun[indexes[partIndex]];
		}
		else
		{
			return null;
		}
	}
	
	public String toString() 
	{
		// Building the word
		StringBuilder sb = new StringBuilder();

		int partIndex = 0;
		
		for (int i = 0; i < adjectivesNumber; i++)
		{
			// Building adjective
			if (adjectiveIsCompound[i])
			{
				sb.append(firstRootParts[indexes[partIndex]].getS());
				partIndex ++;
				sb.append(lastAdjectiveParts[indexes[partIndex]].getForm(getGender()));
			}
			else
			{
				sb.append(singlePartAdjectives[indexes[partIndex]].getForm(getGender()));
			}
			partIndex ++;

			sb.append(" ");
		}

		
		// Building noun
		if (nounIsCompound)
		{
			sb.append(firstRootParts[indexes[partIndex]].getS());
			partIndex ++;
			sb.append(lastNounParts[indexes[partIndex]].getS());
		}
		else
		{
			sb.append(singlePartNoun[indexes[partIndex]].getS());
			
		}
		partIndex ++;
		
		return sb.toString();
	}

	public FunnyCreature(int adjectivesNumber, boolean nounIsCompound, boolean[] adjectiveIsCompound, Integer[] indexes)
	{
		this.adjectiveIsCompound = adjectiveIsCompound.clone();
		this.nounIsCompound = nounIsCompound;
		this.adjectivesNumber = adjectivesNumber;
		this.indexes = indexes.clone();
	}
	
	@Override
	public int hashCode() 
	{
		return toString().hashCode();
	}
}
