package com.apjschool.librarymgmt.util;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class HobbyValidator implements ConstraintValidator<IsValidHobby, String> {

	private String listValidHobbies;
	
	@Override
	public void initialize(IsValidHobby isValidHobby) {	
		//Initialize is call before isValid method
		this.listValidHobbies = isValidHobby.listValidHobbies();
	}

	@Override
	public boolean isValid(String hobby, ConstraintValidatorContext ctx) {

		if(hobby==null) {
			return false;
		} else if (hobby.matches(listValidHobbies)) {
			return true;
		} else {
			return false;
		}		
	}
}
