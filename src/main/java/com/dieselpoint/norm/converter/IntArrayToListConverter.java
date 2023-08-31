package com.dieselpoint.norm.converter;

import java.sql.Array;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.dieselpoint.norm.DbException;

@Converter
public class IntArrayToListConverter implements AttributeConverter<List<Integer>, java.sql.Array> {

	@Override
	public Array convertToDatabaseColumn(List<Integer> attribute) {
		return new SimpleArray(java.sql.Types.INTEGER, attribute.toArray());
	}

	@Override
	public List<Integer> convertToEntityAttribute(Array dbData) {

		try {
			if (dbData.getBaseType() != java.sql.Types.INTEGER) {
				throw new DbException("Database is not returning an integer array");
			}

			return new ArrayList<>(Arrays.asList((Integer[]) dbData.getArray()));

		} catch (SQLException e) {
			throw new DbException(e);
		}
	}

}
