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
	
	public int getLimbsNumber() {
		return limbsNumber;
	}
	
	public int getFingersNumber() {
		return fingersNumber;
	}
}
