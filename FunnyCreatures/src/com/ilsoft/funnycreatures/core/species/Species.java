package com.ilsoft.funnycreatures.core.species;

import java.util.ArrayList;
import java.util.Random;
import java.util.jar.Attributes.Name;

import com.ilsoft.funnycreatures.core.Noun;
import com.ilsoft.funnycreatures.core.NounBase;
import com.ilsoft.funnycreatures.core.species.Species.Covering.Type;

/**
 * Описание биологического вида. Содержит основные свойства вида, такие как тип питания, 
 * ореал обитания и место в пищевой цепочке. 
 */
public class Species {

	/**
	 * Размер особи
	 */
	public enum Size {
		Tiny, 
		Average,
		Huge,
		Giant;
		
		public static Size generate(Random rnd) {
			int r = rnd.nextInt(4);
			switch (r) {
			case 0:
				return Tiny;
			case 1:
				return Average;
			case 2:
				return Huge;
			case 3:
				return Giant;
			default:
				throw new RuntimeException("Strange case in " + Size.class.getName());
			}
		}
	}

	/**
	 * Типы питания
	 */
	public enum FeedingType {
		Predator,		// Хищник 
		Herbivore, 		// Травоядный
		Scavenger;		// Падальщик
		
		public static FeedingType generate(Random rnd) {
			int r = rnd.nextInt(3);
			switch (r) {
			case 0:
				return Predator;
			case 1:
				return Herbivore;
			case 2:
				return Scavenger;
			default:
				throw new RuntimeException("Strange case in " + FeedingType.class.getName());
			}
		}
	}
	
	/**
	 * Ареалы обитания
	 */
	public enum HabitatType {
		Desert,			// Пустыня
		Glade,			// Поляна
		Forest,			// Лес
		Rocks,
		Swamp,			// Болото
		RiverShore;		// Берег реки
		
		public static HabitatType generate(Random rnd) {
			int r = rnd.nextInt(6);
			switch (r) {
			case 0:
				return Desert;
			case 1:
				return Glade;
			case 2:
				return Forest;
			case 3:
				return Rocks;
			case 4:
				return Swamp;
			case 5:
				return RiverShore;
			default:
				throw new RuntimeException("Strange case in " + HabitatType.class.getName());
			}
		}
	}
	
	/**
	 * Окончания конечностей
	 */
	public enum LimbsFinishing {
		Claws, 			// Когти
		Hooves;			// Копыта
		
		public static LimbsFinishing generate(Random rnd) {
			int r = rnd.nextInt(2);
			switch (r) {
			case 0:
				return Claws;
			case 1:
				return Hooves;
			default:
				throw new RuntimeException("Strange case in " + LimbsFinishing.class.getName());
			}
		}
	}
	
	public enum TailType {
		None, 
		Short, 
		Rounded, 
		Long;
		
		public static TailType generate(Random rnd) {
			int r = rnd.nextInt(4);
			switch (r) {
			case 0:
				return None;
			case 1:
				return Short;
			case 2:
				return Rounded;
			case 3:
				return Long;
			default:
				throw new RuntimeException("Strange case in " + TailType.class.getName());
			}
		}
	}
	
	public static class Covering
	{
		public enum Type {
			None,		// Нет
			Fur,		// Мех
			Squama,		// Чешуя
			Spines;		// Иглы
			
			public static Type generate(Random rnd) {
				int r = rnd.nextInt(4);
				switch (r) {
				case 0:
					return None;
				case 1:
					return Fur;
				case 2:
					return Squama;
				case 3:
					return Spines;
				default:
					throw new RuntimeException("Strange case in " + Type.class.getName());
				}
			}
		}

		public enum Length {
			Short, Long;
			
			public static Length generate(Random rnd) {
				return rnd.nextInt(1) > 0 ? Long : Short; 
			}
		}
		
		public enum Density {
			Rare, Dense;

			public static Density generate(Random rnd) {
				return rnd.nextInt(1) > 0 ? Dense : Rare; 
			}
		}
		
		public enum Softness {
			Soft, Hard;
			
			public static Softness generate(Random rnd) {
				return rnd.nextInt(1) > 0 ? Hard : Soft; 
			}			
		}
		
		private Type type;
		private Length length;
		private Density density;
		private Softness softness;
		
		public Type getType() {
			return type;
		}
		public Length getLength() {
			return length;
		}
		public Density getDensity() {
			return density;
		}
		public Softness getSoftness() {
			return softness;
		}
		
		public Covering(Type type, Length length, Density density, Softness softness) {
			this.type = type;
			this.length = length;
			this.density = density;
			this.softness = softness;
		}
		
		public static Covering generate(Random rnd) {
			Type type = Type.generate(rnd);
			Length length = Length.generate(rnd);
			Density density = Density.generate(rnd);
			Softness softness = Softness.generate(rnd);
			
			return new Covering(type, length, density, softness);
		}
	}
	
	/**
	 * В генерации названия вида участвует датчик псевдослучайных чисел.
	 * Чтобы при каждой генерации название получалось одно и то же, он
	 * инициализируется одинм и тем же значением, хранящимся в этой переменной
	 */
	private long nameGeneratorSeed;

	/**
	 * В генерации описания вида участвует датчик псевдослучайных чисел.
	 * Чтобы при каждой генерации название получалось одно и то же, он
	 * инициализируется одиним и тем же значением, хранящимся в этой переменной
	 */
	private long descriptionGeneratorSeed;
	
	private Size size;
	
	private TailType tailType;
	private Covering defaultCovering;	// Стандартное покрытие (если не указано иное, считать покрытие таким)
	private Covering backCovering, 		// Покрытие спины
		bellyCovering, 
		chestCovering,
		frontLimbsCovering, 
		backLimbsCovering, 
		tailCovering, 
		snoutCovering;					// Покрытие морды
	
	
	/**
	 * Количество конечностей
	 */
	private int limbsNumber;

	/**
	 * Количество пальцев
	 */
	private int fingersNumber;
	
	/**
	 * Окончание конечностей
	 */
	private LimbsFinishing limbsFinishing;
	
	/**
	 * Тип питания
	 */
	private FeedingType feedingType;
	
	/**
	 * Ареал обитания
	 */
	private HabitatType habitatType;
	
	private int eyesNumber;
	private int hornsNumber;
	
	public Species(Size size,
	               TailType tailType,
	               Covering defaultCovering,
	               Covering backCovering,
	               Covering bellyCovering,
	               Covering chestCovering,
	               Covering frontLimbsCovering,
	               Covering backLimbsCovering,
	               Covering tailCovering,
	               Covering snoutCovering,
	               LimbsFinishing limbsFinishing,
	               FeedingType feedingType,
	               HabitatType habitatType,
	               int limbsNumber,
	               int fingersNumber,
	               int eyesNumber,
	               int hornsNumber,
	               long nameGeneratorSeed,
	               long descriptionGeneratorSeed)	{
		this.size = size;
		this.tailType = tailType;
		this.defaultCovering = defaultCovering;
		this.backCovering = backCovering;
		this.bellyCovering = bellyCovering;
		this.chestCovering = chestCovering;
		this.frontLimbsCovering = frontLimbsCovering;
		this.backLimbsCovering = backLimbsCovering;
		this.tailCovering = tailCovering;
		this.snoutCovering = snoutCovering;
		this.limbsFinishing = limbsFinishing;
		this.feedingType = feedingType;
		this.habitatType = habitatType;
		this.limbsNumber = limbsNumber;
		this.fingersNumber = fingersNumber;
		this.eyesNumber = eyesNumber;
		this.hornsNumber = hornsNumber;
		this.nameGeneratorSeed = nameGeneratorSeed;
		this.descriptionGeneratorSeed = descriptionGeneratorSeed;
	}
	
	public TailType getTailType() {
		return tailType;
	}

	/**
	 * В генерации названия вида участвует датчик псевдослучайных чисел.
	 * Чтобы при каждой генерации название получалось одно и то же, он
	 * инициализируется одинм и тем же значением, хранящимся в этой переменной
	 */
	public long getNameGeneratorSeed() {
		return nameGeneratorSeed;
	}

	/**
	 * В генерации описания вида участвует датчик псевдослучайных чисел.
	 * Чтобы при каждой генерации название получалось одно и то же, он
	 * инициализируется одиним и тем же значением, хранящимся в этой переменной
	 */
	public long getDescriptionGeneratorSeed() {
		return descriptionGeneratorSeed;
	}

	public Size getSize() {
		return size;
	}

	/**
	 * Количество глаз
	 */
	public int getEyesNumber() {
		return eyesNumber;
	}
	
	/**
	 * Количество рогов
	 */
	public int getHornsNumber() {
		return hornsNumber;
	}
	
	/**
	 * Покрытие тела по умолчанию. Не должно быть null. Это покрытие будет 
	 * у животного на всех частях тела, для которых не указано специальное.
	 */
	public Covering getDefaultCovering() {
		return defaultCovering;
	}

	/**
	 * Покрытие спины. Если значение null, следует брать <code>getDefaultCovering()</code>
	 */
	public Covering getBackCovering() {
		return backCovering;
	}

	/**
	 * Покрытие брюшка. Если значение null, следует брать <code>getDefaultCovering()</code>
	 */
	public Covering getBellyCovering() {
		return bellyCovering;
	}

	/**
	 * Покрытие груди. Если значение null, следует брать <code>getDefaultCovering()</code>
	 */
	public Covering getChestCovering() {
		return chestCovering;
	}

	/**
	 * Покрытие передних конечностей. Если значение null, следует брать <code>getDefaultCovering()</code>
	 */
	public Covering getFrontLimbsCovering() {
		return frontLimbsCovering;
	}

	/**
	 * Покрытие задних конечностей. Если значение null, следует брать <code>getDefaultCovering()</code>
	 */
	public Covering getBackLimbsCovering() {
		return backLimbsCovering;
	}

	/**
	 * Покрытие хвоста. Если значение null, следует брать <code>getDefaultCovering()</code>
	 */
	public Covering getTailCovering() {
		return tailCovering;
	}

	/**
	 * Покрытие морды. Если значение null, следует брать <code>getDefaultCovering()</code>
	 */
	public Covering getSnoutCovering() {
		return snoutCovering;
	}

	/**
	 * Окончание конечностей
	 */
	public LimbsFinishing getLimbsFinishing() {
		return limbsFinishing;
	}

	/**
	 * Способ пропитания
	 */
	public FeedingType getFeedingType() {
		return feedingType;
	}

	/**
	 * Среда обитания
	 */
	public HabitatType getHabitatType() {
		return habitatType;
	}

	/**
	 * Количество конечностей
	 */
	public int getLimbsNumber() {
		return limbsNumber;
	}

	/**
	 * Количество пальцев на одной конечности
	 */
	public int getFingersNumber() {
		return fingersNumber;
	}

	public Noun getNameAsFamilyBase() {
	
		Random rnd = new Random(nameGeneratorSeed);
	
		/*int[] simplePredators = {
			Names.ROOT_FAMILY_SPREADY,
			Names.ROOT_FAMILY_MADEYE,
			Names.ROOT_FAMILY_BITY,
			Names.ROOT_FAMILY_BITEAWAY,
			Names.ROOT_FAMILY_WOOLY
		};

		int[] simpleHerbivores = {
			Names.ROOT_FAMILY_GREBUBLYA,
			Names.ROOT_FAMILY_SCRATCHY,
			Names.ROOT_FAMILY_OUTCRAWLER,
			Names.ROOT_FAMILY_LUMMOXY,
			Names.ROOT_FAMILY_HIDDY,
			Names.ROOT_FAMILY_BUTTCRAWLER,
			Names.ROOT_FAMILY_MUSHROOMEATER,
			Names.ROOT_FAMILY_ROCKCRUNCHER,
			Names.ROOT_FAMILY_WOODCHEWER,
			Names.ROOT_FAMILY_EVILEYE
		};
		
		int[] simpleScavengers = {
			Names.ROOT_FAMILY_SLOWPOKY,
		};*/
		
		// Добавляем простые виды
		ArrayList<Noun> possibilities = new ArrayList<Noun>();
		if (getFeedingType() == FeedingType.Predator)
		{
			// Растопырка
			if ((getSize() == Size.Tiny || getSize() == Size.Average) &&		// Небольшой размер
			    (getHabitatType() == HabitatType.Glade) &&						// Водятся на полянах
			    (getLimbsNumber() > 3))											// Хотя бы три конечности
			{
				possibilities.add(Names.simpleFamiliesNames.get(Names.ROOT_FAMILY_SPREADY));
			}
			
			// Лупоглядень
			if (getEyesNumber() > 0)											// Как минимум 1 глаз
			{
				possibilities.add(Names.simpleFamiliesNames.get(Names.ROOT_FAMILY_MADEYE));
			}
			
			// Кусачка
			if (getSize() == Size.Tiny || getSize() == Size.Average)											// Как минимум 1 глаз
			{
				possibilities.add(Names.simpleFamiliesNames.get(Names.ROOT_FAMILY_BITY));
			}
			
			// Отгрызайка
			possibilities.add(Names.simpleFamiliesNames.get(Names.ROOT_FAMILY_BITEAWAY));
			
			// Шерстень
			if (getSize() == Size.Tiny &&
			    getDefaultCovering().getType() == Type.Fur &&
			    getBackCovering().getType() == null)
			{
				possibilities.add(Names.simpleFamiliesNames.get(Names.ROOT_FAMILY_WOOLY));
			}
		} else if (getFeedingType() == FeedingType.Herbivore) {
			if (getHabitatType() == HabitatType.RiverShore) {
				possibilities.add(Names.simpleFamiliesNames.get(Names.ROOT_FAMILY_GREBUBLYA));
			}
			if (getLimbsFinishing() == LimbsFinishing.Claws) {
				possibilities.add(Names.simpleFamiliesNames.get(Names.ROOT_FAMILY_SCRATCHY));
			}
			if (getHabitatType() == HabitatType.Swamp || getHabitatType() == HabitatType.Glade) {
				possibilities.add(Names.simpleFamiliesNames.get(Names.ROOT_FAMILY_OUTCRAWLER));
			}
			if (getSize() == Size.Huge || getSize() == Size.Giant) {
				possibilities.add(Names.simpleFamiliesNames.get(Names.ROOT_FAMILY_LUMMOXY));
			}

			possibilities.add(Names.simpleFamiliesNames.get(Names.ROOT_FAMILY_HIDDY));
			if (getLimbsNumber() <= 2) {
				possibilities.add(Names.simpleFamiliesNames.get(Names.ROOT_FAMILY_BUTTCRAWLER));
			}
			if (getHabitatType() != HabitatType.Desert) {
				possibilities.add(Names.simpleFamiliesNames.get(Names.ROOT_FAMILY_MUSHROOMEATER));	
			}
			if (getHabitatType() == HabitatType.Rocks || getHabitatType() == HabitatType.RiverShore) {
				possibilities.add(Names.simpleFamiliesNames.get(Names.ROOT_FAMILY_ROCKCRUNCHER));
			}
			if (getHabitatType() == HabitatType.Forest || getHabitatType() == HabitatType.Swamp) {
				possibilities.add(Names.simpleFamiliesNames.get(Names.ROOT_FAMILY_WOODCHEWER));
			}
			if (getEyesNumber() > 0) {
				possibilities.add(Names.simpleFamiliesNames.get(Names.ROOT_FAMILY_EVILEYE));
			}
		} else if (getFeedingType() == FeedingType.Scavenger) {
			if (getSize() == Size.Average || getSize() == Size.Huge) {
				possibilities.add(Names.simpleFamiliesNames.get(Names.ROOT_FAMILY_SLOWPOKY));
			}
		}
		
		// Добавляем составные виды
		
		// Покрытие хвоста
		if (getTailCovering() != null)
		{
			if (getTailCovering().getType() == Type.Fur) {
				possibilities.add(new Noun(Names.roots.get(Names.ROOT_FURRY), new Noun(Names.roots.get(Names.ROOT_TAIL), NounBase.M_HARD_1)));
				possibilities.add(new Noun(Names.roots.get(Names.ROOT_WOOLY), new Noun(Names.roots.get(Names.ROOT_TAIL), NounBase.M_HARD_1)));
			}
			else if (getTailCovering().getType() == Type.Squama) {
				possibilities.add(new Noun(Names.roots.get(Names.ROOT_SQUAMY), new Noun(Names.roots.get(Names.ROOT_TAIL), NounBase.M_HARD_1)));
			}
			else if (getTailCovering().getType() == Type.Spines) {
				possibilities.add(new Noun(Names.roots.get(Names.ROOT_SPINY), new Noun(Names.roots.get(Names.ROOT_TAIL), NounBase.M_HARD_1)));
			}
			else if (getTailCovering().getType() == Type.None) {
				possibilities.add(new Noun(Names.roots.get(Names.ROOT_BOLDY), new Noun(Names.roots.get(Names.ROOT_TAIL), NounBase.M_HARD_1)));
				possibilities.add(new Noun(Names.roots.get(Names.ROOT_SMOOTH), new Noun(Names.roots.get(Names.ROOT_TAIL), NounBase.M_HARD_1)));
			}
		}
		
		// Покрытие лап
		if (getFrontLimbsCovering() != null)
		{
			if (getFrontLimbsCovering().getType() == Type.Fur) {
				possibilities.add(new Noun(Names.roots.get(Names.ROOT_FURRY), new Noun(Names.roots.get(Names.ROOT_LIMB), NounBase.M_HARD_1)));
				possibilities.add(new Noun(Names.roots.get(Names.ROOT_WOOLY), new Noun(Names.roots.get(Names.ROOT_LIMB), NounBase.M_HARD_1)));
			}
			else if (getFrontLimbsCovering().getType() == Type.Squama) {
				possibilities.add(new Noun(Names.roots.get(Names.ROOT_SQUAMY), new Noun(Names.roots.get(Names.ROOT_LIMB), NounBase.M_HARD_1)));
			}
			else if (getFrontLimbsCovering().getType() == Type.Spines) {
				possibilities.add(new Noun(Names.roots.get(Names.ROOT_SPINY), new Noun(Names.roots.get(Names.ROOT_LIMB), NounBase.M_HARD_1)));
			}
			else if (getFrontLimbsCovering().getType() == Type.None) {
				possibilities.add(new Noun(Names.roots.get(Names.ROOT_BOLDY), new Noun(Names.roots.get(Names.ROOT_LIMB), NounBase.M_HARD_1)));
				possibilities.add(new Noun(Names.roots.get(Names.ROOT_SMOOTH), new Noun(Names.roots.get(Names.ROOT_LIMB), NounBase.M_HARD_1)));
			}
			
		}

		if (getBackLimbsCovering() != null)
		{
			if (getBackLimbsCovering().getType() == Type.Fur) {
				possibilities.add(new Noun(Names.roots.get(Names.ROOT_FURRY), new Noun(Names.roots.get(Names.ROOT_LIMB), NounBase.M_HARD_1)));
				possibilities.add(new Noun(Names.roots.get(Names.ROOT_WOOLY), new Noun(Names.roots.get(Names.ROOT_LIMB), NounBase.M_HARD_1)));
			}
			else if (getBackLimbsCovering().getType() == Type.Squama) {
				possibilities.add(new Noun(Names.roots.get(Names.ROOT_SQUAMY), new Noun(Names.roots.get(Names.ROOT_LIMB), NounBase.M_HARD_1)));
			}
			else if (getBackLimbsCovering().getType() == Type.Spines) {
				possibilities.add(new Noun(Names.roots.get(Names.ROOT_SPINY), new Noun(Names.roots.get(Names.ROOT_LIMB), NounBase.M_HARD_1)));
			}
			else if (getBackLimbsCovering().getType() == Type.None) {
				possibilities.add(new Noun(Names.roots.get(Names.ROOT_BOLDY), new Noun(Names.roots.get(Names.ROOT_LIMB), NounBase.M_HARD_1)));
				possibilities.add(new Noun(Names.roots.get(Names.ROOT_SMOOTH), new Noun(Names.roots.get(Names.ROOT_LIMB), NounBase.M_HARD_1)));
			}

		}
		
		// Покрытие пузика
		if (getBellyCovering() != null)
		{
			if (getBellyCovering().getType() == Type.Fur) {
				possibilities.add(new Noun(Names.roots.get(Names.ROOT_FURRY), new Noun(Names.roots.get(Names.ROOT_BELLY), NounBase.M_HARD_1)));
				possibilities.add(new Noun(Names.roots.get(Names.ROOT_WOOLY), new Noun(Names.roots.get(Names.ROOT_BELLY), NounBase.M_HARD_1)));
			}
			else if (getBellyCovering().getType() == Type.Squama) {
				possibilities.add(new Noun(Names.roots.get(Names.ROOT_SQUAMY), new Noun(Names.roots.get(Names.ROOT_BELLY), NounBase.M_HARD_1)));
			}
			else if (getBellyCovering().getType() == Type.Spines) {
				possibilities.add(new Noun(Names.roots.get(Names.ROOT_SPINY), new Noun(Names.roots.get(Names.ROOT_BELLY), NounBase.M_HARD_1)));
			}
			else if (getBellyCovering().getType() == Type.None) {
				possibilities.add(new Noun(Names.roots.get(Names.ROOT_BOLDY), new Noun(Names.roots.get(Names.ROOT_BELLY), NounBase.M_HARD_1)));
				possibilities.add(new Noun(Names.roots.get(Names.ROOT_SMOOTH), new Noun(Names.roots.get(Names.ROOT_BELLY), NounBase.M_HARD_1)));
			}			
		}
		
		// Покрытие морды
		if (getSnoutCovering() != null)
		{
			if (getSnoutCovering().getType() == Type.Fur) {
				possibilities.add(new Noun(Names.roots.get(Names.ROOT_FURRY), new Noun(Names.roots.get(Names.ROOT_SNOUT), NounBase.M_HARD_1)));
			}
			else if (getSnoutCovering().getType() == Type.Squama) {
				possibilities.add(new Noun(Names.roots.get(Names.ROOT_SQUAMY), new Noun(Names.roots.get(Names.ROOT_SNOUT), NounBase.M_HARD_1)));
			}
			else if (getSnoutCovering().getType() == Type.Spines) {
				possibilities.add(new Noun(Names.roots.get(Names.ROOT_SPINY), new Noun(Names.roots.get(Names.ROOT_SNOUT), NounBase.M_HARD_1)));
			}
			else if (getSnoutCovering().getType() == Type.None) {
				possibilities.add(new Noun(Names.roots.get(Names.ROOT_BOLDY), new Noun(Names.roots.get(Names.ROOT_SNOUT), NounBase.M_HARD_1)));
				possibilities.add(new Noun(Names.roots.get(Names.ROOT_SMOOTH), new Noun(Names.roots.get(Names.ROOT_SNOUT), NounBase.M_HARD_1)));
			}			
		}
		
		// Количество конечностей
		if (getLimbsNumber() != 4) {
			possibilities.add(new Noun(Names.quantityRoots.get(getLimbsNumber()), new Noun(Names.roots.get(Names.ROOT_LIMB), NounBase.M_HARD_1)));
		}
		
		// Количество рогов
		if (getHornsNumber() != 0 && getHornsNumber() != 2) {
			possibilities.add(new Noun(Names.quantityRoots.get(getHornsNumber()), new Noun(Names.roots.get(Names.ROOT_HORN), NounBase.M_HARD_1)));
		}
		
		// Хвост
		if (getTailType() == TailType.Long) {
			possibilities.add(new Noun(Names.roots.get(Names.ROOT_LONG), new Noun(Names.roots.get(Names.ROOT_TAIL), NounBase.M_HARD_1)));
		}
		else if (getTailType() == TailType.Short) {
			possibilities.add(new Noun(Names.roots.get(Names.ROOT_SHORT), new Noun(Names.roots.get(Names.ROOT_TAIL), NounBase.M_HARD_1)));
		}
		
		return possibilities.get(rnd.nextInt(possibilities.size()));
	}
	
	/**
	 * Генерирует случайный вид
	 * @param rnd Генератор случайных чисел, используемый при генерации свойств вида
	 */
	public static Species generate(Random rnd) {
		Size size = Size.generate(rnd);
		TailType tailType = TailType.generate(rnd);
		
		Covering defaultCovering = Covering.generate(rnd);
		Covering backCovering = rnd.nextInt(5) == 0 ? Covering.generate(rnd) : null;
		Covering bellyCovering = rnd.nextInt(5) == 0 ? Covering.generate(rnd) : null;
		Covering chestCovering = rnd.nextInt(5) == 0 ? Covering.generate(rnd) : null;
		Covering frontLimbsCovering = rnd.nextInt(5) == 0 ? Covering.generate(rnd) : null;
		Covering backLimbsCovering = rnd.nextInt(5) == 0 ? Covering.generate(rnd) : null;
		Covering tailCovering = rnd.nextInt(5) == 0 ? Covering.generate(rnd) : null;
		Covering snoutCovering = rnd.nextInt(5) == 0 ? Covering.generate(rnd) : null;
		
		LimbsFinishing limbsFinishing = LimbsFinishing.generate(rnd);
		FeedingType feedingType = FeedingType.generate(rnd);
		HabitatType habitatType = HabitatType.generate(rnd);
		int limbsNumber = rnd.nextInt(5) == 0 ? rnd.nextInt(7) + 1 : 4; 	/* С вероятностью 1/5 - от 1 до 8. Иначе - 4 */
		int fingersNumber =  rnd.nextInt(5) == 0 ? rnd.nextInt(6) + 1 : 5; 	/* С вероятностью 1/5 - от 1 до 7. Иначе - 5 */
		int eyesNumber =  rnd.nextInt(5) == 0 ? rnd.nextInt(6) + 1 : 2; 	/* С вероятностью 1/5 - от 1 до 7. Иначе - 2 */
		int hornsNumber =  rnd.nextInt(5) == 0 ? rnd.nextInt(3) + 1 : 0; 	/* С вероятностью 1/5 - от 1 до 3. Иначе - нет */
		
		long nameGeneratorSeed = rnd.nextLong();
		long descriprionGeneratorSeed = rnd.nextLong();
		
		return new Species(size,
		                   tailType,
		                   defaultCovering, 
		                   backCovering, 
		                   bellyCovering, 
		                   chestCovering, 
		                   frontLimbsCovering,
		                   backLimbsCovering,
		                   tailCovering,
		                   snoutCovering,
		                   limbsFinishing,
		                   feedingType,
		                   habitatType,
		                   limbsNumber,
		                   fingersNumber,
		                   eyesNumber,
		                   hornsNumber,
		                   nameGeneratorSeed,
		                   descriprionGeneratorSeed);
	}
}
