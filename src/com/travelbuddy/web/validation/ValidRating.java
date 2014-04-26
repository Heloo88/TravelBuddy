
//* JBoss, Home of Professional Open Source
package com.travelbuddy.web.validation;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ METHOD, FIELD, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = com.travelbuddy.web.validation.ValidRatingImpl.class)
public @interface ValidRating {

	String message() default "This does not appear to be a valid rating";

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };


	int min() default 1;

	//int max() default 10;



}
