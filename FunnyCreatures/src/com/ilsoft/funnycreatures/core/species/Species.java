package com.ilsoft.funnycreatures.core.species;

/**
 * Описание биологического вида. Содержит основные свойства вида, такие как тип питания, 
 * ореал обитания и место в пищевой цепочке. 
 */
public class Species {

	/**
	 * Тип питания
	 */
	public enum FeedingType {
		Predator,		// Хищник 
		Herbivore, 		// Травоядный
		Scavenger		// Падальщик
	}
	
	/**
	 * Ареал обитания
	 */
	public enum HabitatType {
		Glade,			// Поляна
		Forest,			// Лес
		RiverShore		// Берег реки
	}
	
	/**
	 * Окончание конечностей
	 */
	private enum LimbsFinishing {
		Claws, 
	}
	
	private int limbsNumber;
	
	
	private FeedingType feedingType;
	private HabitatType habitatType;
}
