package com.dieselpoint.norm.converter;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.dieselpoint.norm.Util;

@Converter
public class StringToIntListConverter implements AttributeConverter<List<Integer>, String> {

	@Override
	public String convertToDatabaseColumn(List<Integer> attribute) {
		if (attribute == null) {
			return null;
		}
		
		return Util.join(attribute);
	}

	@Override
	public List<Integer> convertToEntityAttribute(String in) {
		// deserialize string in the form "123,456" no spaces allowed
		List<Integer> list = new ArrayList<>();
		int len;
		if (in == null || (len = in.length()) == 0) {
			return list;
		}

		int value = 0;
		for (int i = 0; i < len; i++) {
			int digit = in.charAt(i) - '0';
			if (digit >= 0 && digit <= 9) {
				value = value * 10 + digit;
			} else {
				// hit a comma
				list.add(value);
				value = 0;
			}
		}
		list.add(value);
		return list;
	}

}
