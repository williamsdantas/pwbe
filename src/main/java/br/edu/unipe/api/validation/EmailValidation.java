package br.edu.unipe.api.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = EmailValidator.class)
public @interface EmailValidation {
    String messenger() default "E-mail não é válido, necessário @fuji.com";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
