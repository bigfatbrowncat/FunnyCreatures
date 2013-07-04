package com.ilsoft.funnycreatures.core.species;

/**
 * Описание биологического вида. Содержит основные свойства вида, такие как тип питания, 
 * ореал обитания и место в пищевой цепочке. 
 */
public class Species {

	/**
	 * Типы питания
	 */
	public enum FeedingType {
		Predator,		// Хищник 
		Herbivore, 		// Травоядный
		Scavenger		// Падальщик
	}
	
	/**
	 * Ареалы обитания
	 */
	public enum HabitatType {
		Desert,			// Пустыня
		Glade,			// Поляна
		Forest,			// Лес
		RiverShore		// Берег реки
	}
	
	/**
	 * Окончания конечностей
	 */
	public enum LimbsFinishing {
		Claws, 			// Когти
		Hooves			// Копыта
	}
	
	public enum TailType {
		Long, Rounded, Short, None
	}
	
	public static class Covering
	{
		public enum Type {
			None,		// Нет
			Fur,		// Мех
			Squama,		// Чешуя
			Spines,		// Иглы
		}

		public enum Length {
			Short, Long
		}
		
		public enum Density {
			Dense, Rare
		}
		
		public enum Softness {
			Soft, Hard
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
	}
	
	
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
	
	public int getEyesNumber() {
		return eyesNumber;
	}
	public int getHornsNumber() {
		return hornsNumber;
	}
	public Species(Covering defaultCovering,
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
	               int hornsNumber)	{
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
	}
	
	public Covering getDefaultCovering() {
		return defaultCovering;
	}

	public Covering getBackCovering() {
		return backCovering;
	}

	public Covering getBellyCovering() {
		return bellyCovering;
	}

	public Covering getChestCovering() {
		return chestCovering;
	}

	public Covering getFrontLimbsCovering() {
		return frontLimbsCovering;
	}

	public Covering getBackLimbsCovering() {
		return backLimbsCovering;
	}

	public Covering getTailCovering() {
		return tailCovering;
	}

	public Covering getSnoutCovering() {
		return snoutCovering;
	}

	public LimbsFinishing getLimbsFinishing() {
		return limbsFinishing;
	}

	public FeedingType getFeedingType() {
		return feedingType;
	}

	public HabitatType getHabitatType() {
		return habitatType;
	}

	public int getLimbsNumber() {
		return limbsNumber;
	}
	
	public int getFingersNumber() {
		return fingersNumber;
	}
}
