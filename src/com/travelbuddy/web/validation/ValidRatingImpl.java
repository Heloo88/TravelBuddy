package com.travelbuddy.web.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidRatingImpl implements
		ConstraintValidator<ValidRating, String> {
	private int min;

	@Override
	public void initialize(ValidRating constraintAnnotation) {
		min = constraintAnnotation.min();

	}

	@Override
	public boolean isValid(String review, ConstraintValidatorContext context) {
		if (Integer.parseInt(review) >= min) {
			return true;
		} else {
			return false;
		}
	}

}
