package spring.ui.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import spring.ui.model.MyUser;

public class UserValidator implements Validator {

	public boolean supports(Class<?> clas) {
		return MyUser.class.isAssignableFrom(clas);
	}
	public void validate(Object obj, Errors errors) {
		MyUser user = (MyUser) obj;
		if (user.getName().equals("")) {
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name",
					"name.required");
		} else {
			if (user.getCity().equals("")) {
				ValidationUtils.rejectIfEmptyOrWhitespace(errors, "city",
						"city.required");
			} else {
				if (user.getMobileNo() <= 0) {
					errors.rejectValue("mobileNo", "mobileNo.required");
				} else {
					Pattern p = Pattern.compile("(0|91)?[7-9][0-9]{9}");
					Matcher m = p.matcher("" + user.getMobileNo());
					if (!m.matches()) {
						errors.rejectValue("mobileNo", "mobileNo.validation");
					}
				}
			}
		}
	}
}
