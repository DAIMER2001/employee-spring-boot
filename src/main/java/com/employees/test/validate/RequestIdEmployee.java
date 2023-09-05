package com.employees.test.validate;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.employees.test.common.ErrorCode;
import com.employees.test.common.GetMessageError;
import com.employees.test.exception.EmployeesTestException;

@Component
public class RequestIdEmployee {
    private static final String NUMBERS_PATTERN = "\\d+";

	@Autowired
	GetMessageError messages;

	public boolean validateId(String id) throws EmployeesTestException {
		
		if (id == null || id.isEmpty()) {
				throw new EmployeesTestException(ErrorCode.BAD_REQUEST, messages,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		Pattern regex = Pattern.compile(NUMBERS_PATTERN);

		if (!regex.matcher(id).matches()) {
			throw new EmployeesTestException(ErrorCode.BAD_REQUEST, messages,HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return true;

	}
}
