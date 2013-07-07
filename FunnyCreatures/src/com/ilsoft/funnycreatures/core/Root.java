package com.ilsoft.funnycreatures.core;

/**
 * Корень слова (обобщенный). Состоит из собственно корня - строго неизменяемой
 * части слова и корневой связки, которой данный корень присоединяется к следующему
 */
public class Root
{
	/**
	 * Корневые связки
	 */
	public enum RootLink
	{
		/**
		 * <p>Корневая связка "о"</p>
		 * <p>чешуйчатОкрылый</p>  
		 */
		O("о"), 
		
		/**
		 * <p>Корневая связка "е"</p>
		 * <p>граблЕносый</p>  
		 */
		E("e"),

		/**
		 * <p>Корневая связка "не"</p>
		 * <p>шерстНЕвидный (имитация чередования букв в слове шерстЕНь)</p>  
		 */
		NE("нe"),

		/**
		 * <p>Корневая связка "ьне"</p>
		 * <p>увалЬНЕвидный (имитация чередования букв в слове увалЕНь)</p>  
		 */
		SOFT_NE("ьнe"),

		/**
		 * <p>Корневая связка "ко"</p>
		 * <p>замочКОвидный (имитация чередования букв в слове замочЕК)</p>  
		 */
		KO("ко"),

		/**
		 * <p>Корневая связка "но"</p>
		 * <p>сНОвидение (имитация чередования букв в слове сОН)</p>  
		 */
		NO("но"),
	
		/**
		 * <p>Пустая корневая связка</p>
		 * <p>без_глазый</p>  
		 */
		EMPTY("");
		
		private String s;
		private RootLink(String s)
		{
			this.s = s;
		}

		public String getS() 
		{
			return s;
		}
	}
	
	private String s;
	protected RootLink link;
	
	public Root(String s, RootLink link)
	{
		this.s = s;
		this.link = link;
	}

	public Root(Root root)
	{
		this.s = root.s;
		this.link = root.link;
	}

	public String getS()
	{
		return s;
	}
	
	public String getSWithLink()
	{
		return s + link.getS();
	}
	
	protected Root getRootBase()
	{
		return this;
	}
	
	@Override
	public boolean equals(Object o)
	{
		if (o instanceof Root)
		{
			Root r = (Root)o;
			return s.equals(r.s) && link.equals(r.link);
		}
		else
		{
			return false;
		}
	}
}
