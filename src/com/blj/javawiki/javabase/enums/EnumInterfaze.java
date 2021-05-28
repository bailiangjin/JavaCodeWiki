package com.blj.javawiki.javabase.enums;

/**
 * 使用接口组织枚举
 * 
 * @author blj
 * 
 */
public interface EnumInterfaze
{
	enum Coffee implements EnumInterfaze
	{
		BLACK_COFFEE, DECAF_COFFEE, LATTE, CAPPUCCINO
	}

	enum Dessert implements EnumInterfaze
	{
		FRUIT, CAKE, GELATO
	}

}
