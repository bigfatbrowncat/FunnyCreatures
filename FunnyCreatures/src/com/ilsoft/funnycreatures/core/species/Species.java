package com.ilsoft.funnycreatures.core.species;

/**
 * �������� �������������� ����. �������� �������� �������� ����, ����� ��� ��� �������, 
 * ����� �������� � ����� � ������� �������. 
 */
public class Species {

	/**
	 * ��� �������
	 */
	public enum FeedingType {
		Predator,		// ������ 
		Herbivore, 		// ����������
		Scavenger		// ���������
	}
	
	/**
	 * ����� ��������
	 */
	public enum HabitatType {
		Glade,			// ������
		Forest,			// ���
		RiverShore		// ����� ����
	}
	
	/**
	 * ��������� �����������
	 */
	private enum LimbsFinishing {
		Claws, 
	}
	
	private int limbsNumber;
	
	
	private FeedingType feedingType;
	private HabitatType habitatType;
}
