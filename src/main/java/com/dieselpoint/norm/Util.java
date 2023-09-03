package com.dieselpoint.norm;

import java.util.List;

public class Util {

	/**
	 * @param objs | Objects to join with ',' delimiter.
	 * 
	 * @return Same as {@link String#join(CharSequence, CharSequence...)} only for ant {@link Object}!
	 */
	public static String join(Object[] objs)
	{
		return join(objs, ',');
	}
	
	/**
	 * @param objs | Objects to join with ',' delimeter.
	 * @param delimeter | delimiter to separate objects with
	 * 
	 * @return Same as {@link String#join(CharSequence, CharSequence...)} only for ant {@link Object}!
	 */
	public static String join(Object[] objs, char delimiter) {
		StringBuilder buf = new StringBuilder();
		for (int i = 0, size = objs.length; i < size; i++) {
			if (i > 0)
				buf.append(delimiter);

			buf.append(objs[i]);
		}

		return buf.toString();
	}

	/**
	 * @param objs | Objects to join with ',' delimiter.
	 * 
	 * @return Same as {@link String#join(CharSequence, CharSequence...)} only for ant {@link Object}!
	 */
	public static String join(List<?> strs)
	{
		return join(strs, ',');
	}
	
	/**
	 * @param objs | Objects to join with ',' delimeter.
	 * @param delimeter | delimiter to separate objects with
	 * 
	 * @return Same as {@link String#join(CharSequence, CharSequence...)} only for ant {@link Object}!
	 */
	public static String join(List<?> objs, char delimeter) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0, size = objs.size(); i < size; i++) {
			if (i > 0) {
				sb.append(delimeter);
			}
			sb.append(objs.get(i));
		}
		return sb.toString();
	}

	/**
	 * @param ch | Char to join count times.
	 * @param count | How many times to join ch.
	 * 
	 * @return ch separated with ',' as delimiter counr times. For example <code>joinChars('?', 3)</code> will return "?,?,?"!
	 */
	public static String joinChars(char ch, int count) {
		StringBuilder sb = new StringBuilder(count * 2);
		for (int i = 0; i < count; i++) {
			if (i > 0)
				sb.append(',');

			sb.append(ch);
		}
		return sb.toString();
	}

	/**
	 * @return True if c is primitive datatype or {@link String}!
	 */
	public static boolean isPrimitiveOrString(Class<?> c) {
		if (c.isPrimitive())
			return true;
		
		return c == Byte.class || c == Short.class || c == Integer.class || c == Long.class || c == Float.class || 
				c == Double.class || c == Boolean.class || c == Character.class || c == String.class;
	}

	/**
	 * @return Type class "wrappered" to its wrapper type. If class is not of primitive type then return type...
	 */
	public static Class<?> wrap(Class<?> type) { // ? NOT USED IN LIBRARY
		if (type == int.class) {
			return Integer.class;
		}
		if (type == long.class) {
			return Long.class;
		}
		if (type == boolean.class) {
			return Boolean.class;
		}
		if (type == byte.class) {
			return Byte.class;
		}
		if (type == char.class) {
			return Character.class;
		}
		if (type == double.class) {
			return Double.class;
		}
		if (type == float.class) {
			return Float.class;
		}
		if (type == short.class) {
			return Short.class;
		}
		if (type == void.class) {
			return Void.class;
		}
		return type;
	}
}
