package com.ilsoft.funnycreatures.core.species;

import java.util.HashMap;
import android.annotation.SuppressLint;

import com.ilsoft.funnycreatures.core.Adjective;
import com.ilsoft.funnycreatures.core.AdjectiveBase;
import com.ilsoft.funnycreatures.core.Noun;
import com.ilsoft.funnycreatures.core.NounBase;
import com.ilsoft.funnycreatures.core.Root;
import com.ilsoft.funnycreatures.core.RootWithSuffixes;
import com.ilsoft.funnycreatures.core.Suffix;
import com.ilsoft.funnycreatures.core.Root.RootLink;

@SuppressLint("UseSparseArrays")
public class Names {
	
	public static final int ROOT_SIMPLE = 600;
	public static final int ROOT_FALSE = 601;
	public static final int ROOT_ALIKE = 602;
	public static final int ROOT_ALIKE_2 = 603;
	public static final int ROOT_ALIKE_3 = 604;

	public static final int ROOT_HABITAT_DESERT = 701;
	public static final int ROOT_HABITAT_RIVER = 702;
	public static final int ROOT_HABITAT_FOREST = 703;
	public static final int ROOT_HABITAT_SANDY = 704;
	public static final int ROOT_HABITAT_BUSHY = 705;
	public static final int ROOT_HABITAT_SWAMPY = 706;
	public static final int ROOT_HABITAT_HERBY = 707;
	public static final int ROOT_HABITAT_ROCKY = 708;

	public static final int ROOT_FAMILY_SPREADY = 500;
	public static final int ROOT_FAMILY_GREBUBLYA = 501;
	public static final int ROOT_FAMILY_MADEYE = 502;
	public static final int ROOT_FAMILY_BITY = 503;
	public static final int ROOT_FAMILY_SCRATCHY = 504;
	public static final int ROOT_FAMILY_OUTCRAWLER = 505;
	public static final int ROOT_FAMILY_LUMMOXY = 506;
	public static final int ROOT_FAMILY_HIDDY = 507;
	public static final int ROOT_FAMILY_BITEAWAY = 508;
	public static final int ROOT_FAMILY_BUTTCRAWLER = 509;
	public static final int ROOT_FAMILY_MUSHROOMEATER = 510;
	public static final int ROOT_FAMILY_ROCKCRUNCHER = 511;
	public static final int ROOT_FAMILY_WOODCHEWER = 512;
	public static final int ROOT_FAMILY_SLOWPOKY = 513;
	public static final int ROOT_FAMILY_WOOLY = 514;
	public static final int ROOT_FAMILY_EVILEYE = 515;

	public static final int ROOT_TAIL = 100;
	public static final int ROOT_EAR = 101;
	public static final int ROOT_LIMB = 102;
	public static final int ROOT_SNOUT = 104;
	public static final int ROOT_BUTT = 105;
	public static final int ROOT_NOSE = 106;
	public static final int ROOT_BELLY = 108;
	public static final int ROOT_BEAK = 109;
	public static final int ROOT_PROBOSCIS = 111;
	public static final int ROOT_FANG = 112;
	public static final int ROOT_CLAWS = 113;
	public static final int ROOT_HOOVES = 114;
	
	public static final int ROOT_RAKE = 300;
	public static final int ROOT_SKEW = 301;
	public static final int ROOT_GNARLY = 302;
	public static final int ROOT_HORN = 303;
	public static final int ROOT_MEMBRANOUS = 304;
	public static final int ROOT_SMOOTH = 305;
	public static final int ROOT_BLUNT = 308;
	public static final int ROOT_SHARP = 309;
	public static final int ROOT_CONVEX = 312;
	public static final int ROOT_NARROW = 313;
	public static final int ROOT_FLAP = 315;
	public static final int ROOT_STICK_OUT = 316;

	public static final int ROOT_LONG = 310;
	public static final int ROOT_OBLONG = 314;
	public static final int ROOT_SHORT = 311;
	public static final int ROOT_THICK = 318;

	public static final int ROOT_STRIPED = 306;
	public static final int ROOT_DOTTED = 307;
	public static final int ROOT_PALE = 319;

	public static final int ROOT_BOLDY = 408;
	public static final int ROOT_FURRY = 409;
	public static final int ROOT_WOOLY = 410;
	public static final int ROOT_SQUAMY = 411;
	public static final int ROOT_SPINY = 412;
	

	public static final HashMap<Integer, Root> quantityRoots = new HashMap<Integer, Root>();
	static {
		quantityRoots.put(0, new Root("без", RootLink.EMPTY));
		quantityRoots.put(1, new Root("един", RootLink.O));
		quantityRoots.put(2, new Root("дву", RootLink.EMPTY));
		quantityRoots.put(3, new Root("трёх", RootLink.EMPTY));
		quantityRoots.put(4, new Root("четырех", RootLink.EMPTY));
		quantityRoots.put(5, new Root("пяти", RootLink.EMPTY));
		quantityRoots.put(6, new Root("шести", RootLink.EMPTY));
		quantityRoots.put(7, new Root("семи", RootLink.EMPTY));
		quantityRoots.put(8, new Root("восьми", RootLink.EMPTY));
	}
	
	public static final HashMap<Integer, Root> roots = new HashMap<Integer, Root>();
	static {
		// Частетельно
		roots.put(ROOT_CLAWS, new Root("когтист", RootLink.O));
		roots.put(ROOT_HOOVES, new Root("копытн", RootLink.O));
		roots.put(ROOT_TAIL, new Root("хвост", RootLink.O));
		roots.put(ROOT_EAR, new Root("ух", RootLink.O));
		roots.put(ROOT_LIMB, new Root("лап", RootLink.O));
		roots.put(ROOT_SNOUT, new Root("морд", RootLink.O));
		roots.put(ROOT_BUTT, new Root("зад", RootLink.O));
		roots.put(ROOT_NOSE, new Root("нос", RootLink.O));
		roots.put(ROOT_BELLY, new Root("пуз", RootLink.O));
		roots.put(ROOT_BEAK, new Root("клюв", RootLink.O));
		roots.put(ROOT_PROBOSCIS, new Root("хобот", RootLink.O));
		roots.put(ROOT_FANG, new Root("клыкаст", RootLink.O));
		
		roots.put(ROOT_HORN, new Root("рог", RootLink.O));
		roots.put(ROOT_SMOOTH, new Root("гладк", RootLink.O));
		roots.put(ROOT_LONG, new Root("длинн", RootLink.O));
		roots.put(ROOT_OBLONG, new Root("продолговат", RootLink.O));
		roots.put(ROOT_SHORT, new Root("коротк", RootLink.O));
		roots.put(ROOT_THICK, new Root("толст", RootLink.O));

		// Внешне
		roots.put(ROOT_RAKE, new Root("грабл", RootLink.E));
		roots.put(ROOT_SKEW, new Root("кос", RootLink.O));
		roots.put(ROOT_GNARLY, new Root("шишк", RootLink.O));
		roots.put(ROOT_MEMBRANOUS, new Root("перепончат", RootLink.O));
		roots.put(ROOT_STRIPED, new Root("полосат", RootLink.O));
		roots.put(ROOT_DOTTED, new Root("пятнист", RootLink.O));
		roots.put(ROOT_BLUNT, new Root("туп", RootLink.O));
		roots.put(ROOT_SHARP, new Root("остр", RootLink.O));
		roots.put(ROOT_CONVEX, new Root("выпукл", RootLink.O));
		roots.put(ROOT_NARROW, new Root("узк", RootLink.O));
		roots.put(ROOT_FLAP, new Root("висл", RootLink.O));
		roots.put(ROOT_STICK_OUT, new Root("торчк", RootLink.O));
		roots.put(ROOT_PALE, new Root("бледн", RootLink.O));

		roots.put(ROOT_BOLDY, new Root("лыс", RootLink.O));
		roots.put(ROOT_FURRY, new Root("пушист", RootLink.O));
		roots.put(ROOT_WOOLY, new Root("шерст", RootLink.E));
		roots.put(ROOT_SQUAMY, new Root("чешуйчат", RootLink.O));
		roots.put(ROOT_SPINY, new Root("шипаст", RootLink.O));

		roots.put(ROOT_FAMILY_SPREADY, new Root("растопыр", RootLink.KO));
		roots.put(ROOT_FAMILY_GREBUBLYA, new Root("гребубл", RootLink.E));
		roots.put(ROOT_FAMILY_MADEYE, new Root("лупогляд", RootLink.NE));
		roots.put(ROOT_FAMILY_BITY, new Root("кусачк", RootLink.O));
		roots.put(ROOT_FAMILY_SCRATCHY, new Root("царапк", RootLink.O));
		roots.put(ROOT_FAMILY_OUTCRAWLER, new Root("выполз", RootLink.NE));
		roots.put(ROOT_FAMILY_LUMMOXY, new Root("увал", RootLink.SOFT_NE));
		roots.put(ROOT_FAMILY_HIDDY, new Root("невид", RootLink.NE));
		roots.put(ROOT_FAMILY_BITEAWAY, new Root("отгрызайк", RootLink.O));
		roots.put(ROOT_FAMILY_BUTTCRAWLER, new Root("уползад", RootLink.O));
		roots.put(ROOT_FAMILY_MUSHROOMEATER, new Root("грибоед", RootLink.O));
		roots.put(ROOT_FAMILY_ROCKCRUNCHER, new Root("камнегрыз", RootLink.O));
		roots.put(ROOT_FAMILY_WOODCHEWER, new Root("древожу", RootLink.E));
		roots.put(ROOT_FAMILY_SLOWPOKY, new Root("тормоз", RootLink.NE));
		roots.put(ROOT_FAMILY_WOOLY, new Root("шерст", RootLink.NE));
		roots.put(ROOT_FAMILY_EVILEYE, new Root("злобнозырк", RootLink.O));
		
		roots.put(ROOT_SIMPLE, new Root("обыкновенн", RootLink.O));
		roots.put(ROOT_FALSE, new Root("ложн", RootLink.O));
		roots.put(ROOT_ALIKE, new Root("образн", RootLink.O));
		roots.put(ROOT_ALIKE_2, new Root("видн", RootLink.O));
		roots.put(ROOT_ALIKE_3, new Root("подобн", RootLink.O));
		
		roots.put(ROOT_HABITAT_DESERT, new Root("пустынн", RootLink.O));
		roots.put(ROOT_HABITAT_RIVER, new Root("речн", RootLink.O));
		roots.put(ROOT_HABITAT_FOREST, new Root("лесн", RootLink.O));
		roots.put(ROOT_HABITAT_SANDY, new Root("песчан", RootLink.O));
		roots.put(ROOT_HABITAT_BUSHY, new Root("закустов", RootLink.O));
		roots.put(ROOT_HABITAT_SWAMPY, new Root("болотн", RootLink.O));
		roots.put(ROOT_HABITAT_HERBY, new Root("травянист", RootLink.O));
		roots.put(ROOT_HABITAT_ROCKY, new Root("подкамнев", RootLink.O));

	}

	public static final HashMap<Integer, Noun> simpleFamiliesNames = new HashMap<Integer, Noun>();	
	static {
		simpleFamiliesNames.put(ROOT_FAMILY_SPREADY, new Noun(new RootWithSuffixes(roots.get(ROOT_FAMILY_SPREADY), Suffix.K, RootLink.O), NounBase.F_HARD_1));
		simpleFamiliesNames.put(ROOT_FAMILY_GREBUBLYA, new Noun(roots.get(ROOT_FAMILY_GREBUBLYA), NounBase.F_SOFT_1));
		simpleFamiliesNames.put(ROOT_FAMILY_MADEYE, new Noun(roots.get(ROOT_FAMILY_MADEYE), NounBase.M_2));
		simpleFamiliesNames.put(ROOT_FAMILY_BITY, new Noun(roots.get(ROOT_FAMILY_BITY), NounBase.F_HARD_1));
		simpleFamiliesNames.put(ROOT_FAMILY_SCRATCHY, new Noun(roots.get(ROOT_FAMILY_SCRATCHY), NounBase.F_HARD_1));
		simpleFamiliesNames.put(ROOT_FAMILY_OUTCRAWLER, new Noun(roots.get(ROOT_FAMILY_OUTCRAWLER), NounBase.M_2));
		simpleFamiliesNames.put(ROOT_FAMILY_LUMMOXY, new Noun(roots.get(ROOT_FAMILY_LUMMOXY), NounBase.M_2));
		simpleFamiliesNames.put(ROOT_FAMILY_HIDDY, new Noun(roots.get(ROOT_FAMILY_HIDDY), NounBase.M_2));
		simpleFamiliesNames.put(ROOT_FAMILY_BITEAWAY, new Noun(roots.get(ROOT_FAMILY_BITEAWAY), NounBase.F_HARD_1));
		simpleFamiliesNames.put(ROOT_FAMILY_BUTTCRAWLER, new Noun(roots.get(ROOT_FAMILY_BUTTCRAWLER), NounBase.M_HARD_1));
		simpleFamiliesNames.put(ROOT_FAMILY_MUSHROOMEATER, new Noun(roots.get(ROOT_FAMILY_MUSHROOMEATER), NounBase.M_HARD_1));
		simpleFamiliesNames.put(ROOT_FAMILY_ROCKCRUNCHER, new Noun(roots.get(ROOT_FAMILY_ROCKCRUNCHER), NounBase.M_HARD_1));
		simpleFamiliesNames.put(ROOT_FAMILY_WOODCHEWER, new Noun(roots.get(ROOT_FAMILY_WOODCHEWER), NounBase.M_SOFT_1));
		simpleFamiliesNames.put(ROOT_FAMILY_SLOWPOKY, new Noun(roots.get(ROOT_FAMILY_SLOWPOKY), NounBase.M_2));
		simpleFamiliesNames.put(ROOT_FAMILY_WOOLY, new Noun(roots.get(ROOT_FAMILY_WOOLY), NounBase.M_2));
		simpleFamiliesNames.put(ROOT_FAMILY_EVILEYE, new Noun(roots.get(ROOT_FAMILY_EVILEYE), NounBase.M_HARD_1));
	}
	
	
	public static final HashMap<Integer, Adjective> adjectiveLastParts = new HashMap<Integer, Adjective>();
	static {
		adjectiveLastParts.put(ROOT_TAIL, new Adjective(roots.get(ROOT_TAIL), AdjectiveBase.HARD));
		adjectiveLastParts.put(ROOT_EAR, new Adjective(roots.get(ROOT_EAR), AdjectiveBase.SOFT));
		adjectiveLastParts.put(ROOT_LIMB, new Adjective(roots.get(ROOT_LIMB), AdjectiveBase.HARD));
		adjectiveLastParts.put(ROOT_SNOUT, new Adjective(roots.get(ROOT_SNOUT), AdjectiveBase.HARD));
		adjectiveLastParts.put(ROOT_BUTT, new Adjective(roots.get(ROOT_BUTT), AdjectiveBase.HARD));
		adjectiveLastParts.put(ROOT_NOSE, new Adjective(roots.get(ROOT_NOSE), AdjectiveBase.HARD));
		adjectiveLastParts.put(ROOT_BELLY, new Adjective(roots.get(ROOT_BELLY), AdjectiveBase.HARD));
		adjectiveLastParts.put(ROOT_BEAK, new Adjective(roots.get(ROOT_BEAK), AdjectiveBase.HARD));
		adjectiveLastParts.put(ROOT_PROBOSCIS, new Adjective(new RootWithSuffixes(roots.get(ROOT_PROBOSCIS), Suffix.YAN, RootLink.O), AdjectiveBase.OLD));
		adjectiveLastParts.put(ROOT_FANG, new Adjective(roots.get(ROOT_FANG), AdjectiveBase.HARD));
		adjectiveLastParts.put(ROOT_HOOVES, new Adjective(roots.get(ROOT_HOOVES), AdjectiveBase.HARD));

		adjectiveLastParts.put(ROOT_RAKE, new Adjective(new RootWithSuffixes(roots.get(ROOT_RAKE), Suffix.YAN, RootLink.O), AdjectiveBase.HARD));
		adjectiveLastParts.put(ROOT_SKEW, new Adjective(roots.get(ROOT_SKEW), AdjectiveBase.OLD));
		adjectiveLastParts.put(ROOT_GNARLY, new Adjective(new RootWithSuffixes(new RootWithSuffixes(roots.get(ROOT_GNARLY), Suffix.OV, RootLink.O), Suffix.AT, RootLink.O), AdjectiveBase.HARD));
		adjectiveLastParts.put(ROOT_HORN, new Adjective(roots.get(ROOT_HORN), AdjectiveBase.SOFT));
		adjectiveLastParts.put(ROOT_MEMBRANOUS, new Adjective(roots.get(ROOT_MEMBRANOUS), AdjectiveBase.HARD));
		adjectiveLastParts.put(ROOT_SMOOTH, new Adjective(roots.get(ROOT_SMOOTH), AdjectiveBase.SOFT));
		adjectiveLastParts.put(ROOT_STRIPED, new Adjective(roots.get(ROOT_STRIPED), AdjectiveBase.HARD));
		adjectiveLastParts.put(ROOT_DOTTED, new Adjective(roots.get(ROOT_DOTTED), AdjectiveBase.HARD));
		adjectiveLastParts.put(ROOT_BLUNT, new Adjective(roots.get(ROOT_BLUNT), AdjectiveBase.OLD));
		adjectiveLastParts.put(ROOT_SHARP, new Adjective(roots.get(ROOT_SHARP), AdjectiveBase.HARD));
		adjectiveLastParts.put(ROOT_LONG, new Adjective(roots.get(ROOT_LONG), AdjectiveBase.HARD));
		adjectiveLastParts.put(ROOT_SHORT, new Adjective(roots.get(ROOT_SHORT), AdjectiveBase.SOFT));
		adjectiveLastParts.put(ROOT_CONVEX, new Adjective(roots.get(ROOT_CONVEX), AdjectiveBase.HARD));
		adjectiveLastParts.put(ROOT_NARROW, new Adjective(roots.get(ROOT_NARROW), AdjectiveBase.SOFT));
		adjectiveLastParts.put(ROOT_OBLONG, new Adjective(roots.get(ROOT_OBLONG), AdjectiveBase.HARD));
		adjectiveLastParts.put(ROOT_FLAP, new Adjective(roots.get(ROOT_FLAP), AdjectiveBase.HARD));
		adjectiveLastParts.put(ROOT_STICK_OUT, new Adjective(new RootWithSuffixes(roots.get(ROOT_STICK_OUT), Suffix.OV, RootLink.O), AdjectiveBase.HARD));
		adjectiveLastParts.put(ROOT_THICK, new Adjective(roots.get(ROOT_THICK), AdjectiveBase.HARD));
		adjectiveLastParts.put(ROOT_PALE, new Adjective(roots.get(ROOT_PALE), AdjectiveBase.HARD));

		adjectiveLastParts.put(ROOT_FURRY, new Adjective(new RootWithSuffixes(roots.get(ROOT_FURRY), Suffix.N, RootLink.O), AdjectiveBase.HARD));
		
		adjectiveLastParts.put(ROOT_FAMILY_SPREADY, new Adjective
		(
			new RootWithSuffixes
			(
				new RootWithSuffixes
				(
					roots.get(ROOT_FAMILY_SPREADY), 
					Suffix.CH, RootLink.E
				), 
				Suffix.AT, RootLink.O
			),
			AdjectiveBase.HARD
		));
		
		adjectiveLastParts.put(ROOT_SIMPLE, new Adjective(roots.get(ROOT_SIMPLE), AdjectiveBase.HARD));
		adjectiveLastParts.put(ROOT_FALSE, new Adjective(roots.get(ROOT_FALSE), AdjectiveBase.HARD));
		adjectiveLastParts.put(ROOT_ALIKE, new Adjective(roots.get(ROOT_ALIKE), AdjectiveBase.HARD));
		adjectiveLastParts.put(ROOT_ALIKE_2, new Adjective(roots.get(ROOT_ALIKE_2), AdjectiveBase.HARD));
		adjectiveLastParts.put(ROOT_ALIKE_3, new Adjective(roots.get(ROOT_ALIKE_3), AdjectiveBase.HARD));

		adjectiveLastParts.put(ROOT_HABITAT_BUSHY, new Adjective(roots.get(ROOT_HABITAT_BUSHY), AdjectiveBase.HARD));
		adjectiveLastParts.put(ROOT_HABITAT_DESERT, new Adjective(roots.get(ROOT_HABITAT_DESERT), AdjectiveBase.HARD));
		adjectiveLastParts.put(ROOT_HABITAT_FOREST, new Adjective(roots.get(ROOT_HABITAT_FOREST), AdjectiveBase.OLD));
		adjectiveLastParts.put(ROOT_HABITAT_HERBY, new Adjective(roots.get(ROOT_HABITAT_HERBY), AdjectiveBase.HARD));
		adjectiveLastParts.put(ROOT_HABITAT_RIVER, new Adjective(roots.get(ROOT_HABITAT_RIVER), AdjectiveBase.OLD));
		adjectiveLastParts.put(ROOT_HABITAT_ROCKY, new Adjective(roots.get(ROOT_HABITAT_ROCKY), AdjectiveBase.HARD));
		adjectiveLastParts.put(ROOT_HABITAT_SANDY, new Adjective(roots.get(ROOT_HABITAT_SANDY), AdjectiveBase.HARD));
		adjectiveLastParts.put(ROOT_HABITAT_SWAMPY, new Adjective(roots.get(ROOT_HABITAT_SWAMPY), AdjectiveBase.HARD));
	}
}

