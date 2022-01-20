package cland.constant;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class PictureValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		String fileName = (String) target;
		if(fileName.equals("")) {
			errors.rejectValue("picture", null, "Vui lòng chọn hình ảnh");
		}
	}

}
