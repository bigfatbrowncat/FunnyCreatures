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
	private enum LimbsFinishing {
		Claws, 			// Когти
		Hooves			// Копыта
	}
	
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
}
