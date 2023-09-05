package com.employees.test.common;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

@Service
public class GetMessageError {
    

	@Autowired
	private MessageSource messageSource;

	public String getMessageError(String message, String [] parameters) {
	    Locale locale = new Locale("es", "CO");
		return this.messageSource.getMessage(message, parameters, locale);
	}

	public String getMessageError(String message) {
		Locale locale = new Locale("es", "CO");

		return this.messageSource.getMessage(message, null, locale);
	}
}
