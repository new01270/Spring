package co.syeon.spex.member.vo;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class MemberValidation implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		MemberVO vo = (MemberVO) target;
		
		// 아이디
		ValidationUtils.rejectIfEmpty(errors, "memberid", null, "아이디입력");
		
		// 이름
		if (vo.getMembername() == null) {
			errors.rejectValue("membername", null, "이름입력");
		}
	}

}
