package com.dieselpoint.norm;

import java.util.List;

public class Util {

	public static String join(Object[] strs)
	{
		return join(strs, ',');
	}
	
	public static String join(Object[] strs, char delimeter) {
		StringBuilder buf = new StringBuilder();
		for (int i = 0, size = strs.length; i < size; i++) {
			if (i > 0)
				buf.append(delimeter);

			buf.append(strs[i]);
		}
		return buf.toString();
	}

	public static String join(List<?> strs)
	{
		return join(strs, ',');
	}
	
	public static String join(List<?> strs, char delimeter) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0, size = strs.size(); i < size; i++) {
			if (i > 0) {
				sb.append(delimeter);
			}
			sb.append(strs.get(i));
		}
		return sb.toString();
	}

	public static String getQuestionMarks(int count) {
		StringBuilder sb = new StringBuilder(count * 2);
		for (int i = 0; i < count; i++) {
			if (i > 0)
				sb.append(',');

			sb.append('?');
		}
		return sb.toString();
	}

	public static boolean isPrimitiveOrString(Class<?> c) {
		if (c.isPrimitive())
			return true;
		
		return c == Byte.class || c == Short.class || c == Integer.class || c == Long.class || c == Float.class || 
				c == Double.class || c == Boolean.class || c == Character.class || c == String.class;
	}

	public static Class<?> wrap(Class<?> type) {
		if (!type.isPrimitive()) {
			return type;
		}
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
		throw new RuntimeException("Will never get here");
	}
}
