package com.dbal.app.emp;

import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


public class EmpValidation implements Validator{

	String REGEX_EMAIL = "^([a-zA-Z0-9\\-\\.\\_]+)'+'(\\@)([a-zA-Z0-9\\-\\.]+)'+'(\\.)([a-zA-Z]{2,4})$";

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "employeeId", "errors.required",new Object[]{"employeeId"}, "사번입력");
		ValidationUtils.rejectIfEmpty(errors, "firstName", "errors.required", new Object[] {"firstName"},"이름입력");
		ValidationUtils.rejectIfEmpty(errors, "lastName", null,"last입력");
		Pattern email = Pattern.compile(REGEX_EMAIL);
		if(! email.matcher("").matches()) {
			errors.rejectValue("email", null, "이메일형식이 아닙니다.");
		}
	}
}
