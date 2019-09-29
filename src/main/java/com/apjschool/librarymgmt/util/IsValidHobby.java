package com.apjschool.librarymgmt.util;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy= {HobbyValidator.class})
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface IsValidHobby {
	
	String message() default "Please provide a valid hobby; accepted hobbies are - Cooking";
	
	Class<?>[] groups() default {};
	
	Class<? extends Payload>[] payload() default{};

	String listValidHobbies() default "Cooking";

}
