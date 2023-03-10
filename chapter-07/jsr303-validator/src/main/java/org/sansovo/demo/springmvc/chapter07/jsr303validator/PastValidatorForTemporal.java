package org.sansovo.demo.springmvc.chapter07.jsr303validator;

/*
 * Past LocalDate validator, declare and validate application constraints
 *
 * License: Apache License, Version 2.0
 * See the license.txt file in the root directory or <http://www.apache.org/licenses/LICENSE-2.0>.
 */

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.constraints.Past;
import java.time.*;
import java.time.temporal.Temporal;

public class PastValidatorForTemporal implements ConstraintValidator<Past, Temporal> {

    @Override
    public void initialize(Past constraintAnnotation) {
    }

    @Override
    public boolean isValid(Temporal temporal, ConstraintValidatorContext constraintValidatorContext) {
        //null values are valid
        if (temporal == null) {
            return true;
        }
        if (temporal instanceof LocalDate) {
            return ((LocalDate) temporal).isBefore(LocalDate.now());
        } else if (temporal instanceof LocalDateTime) {
            return ((LocalDateTime) temporal).isBefore(LocalDateTime.now());
        } else if (temporal instanceof LocalTime) {
            return ((LocalTime) temporal).isBefore(LocalTime.now());
        } else if (temporal instanceof YearMonth) {
            return ((YearMonth) temporal).isBefore(YearMonth.now());
        } else if (temporal instanceof Year) {
            return ((Year) temporal).isBefore(Year.now());
        }
        return false;
    }
}