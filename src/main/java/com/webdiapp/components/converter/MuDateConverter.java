package com.webdiapp.components.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class MuDateConverter implements Converter<String, Date> {

	@Override
	public Date convert(String value) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = simpleDateFormat.parse(value);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

}
