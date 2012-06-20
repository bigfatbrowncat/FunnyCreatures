package com.ilsoft.funnycreatures.core;

public class Noun
{
	public enum Gender { Male, Female }

	private int id;
	private String s;
	private Gender gender;
	
	public Noun(int id, String s, Gender gender)
	{
		this.id = id;
		this.s = s;
		this.gender = gender;
	}

	public int getId() {
		return id;
	}

	public String getS() {
		return s;
	}
	
	public Gender getGender()
	{
		return gender;
	}
}
