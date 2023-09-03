package com.dieselpoint.norm.sqlmakers;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import javax.persistence.AttributeConverter;
import javax.persistence.Column;
import javax.persistence.EnumType;

import com.dieselpoint.norm.serialize.DbSerializable;

/**
 * Contains information about single field of java Object.
 * It is used for both SQL generation and reading / writing into objects...
 * 
 * @see PojoInfo
 */
@SuppressWarnings("rawtypes")
public class Property {
	public String name;
	public Method readMethod;
	public Method writeMethod;
	public Field field;
	public Class<?> dataType;
	public boolean isGenerated;
	public boolean isPrimaryKey;
	public boolean isEnumField;
	public Class<Enum> enumClass;
	public EnumType enumType;
	public Column columnAnnotation;
	public DbSerializable serializer;
	public AttributeConverter<? super Object, ? super Object> converter;
}
