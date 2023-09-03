package com.dieselpoint.norm.sqlmakers;

/**
 * Interface that provides basic means of getting information about Plain Old Java Object (pojo) and allows you to dynamically read and write into its fields.
 * Used mainly internally for pojo to database entity/record mapping!
 * 
 * @see SqlMaker
 */
public interface PojoInfo {

	Object getValue(Object pojo, String name);

	default void putValue(Object pojo, String name, Object value) {
		putValue(pojo, name, value, false);
	}
	
	void putValue(Object pojo, String name, Object value, boolean ignoreIfMissing);

	String[] getGeneratedColumnNames();

	Property getProperty(String name);

}
