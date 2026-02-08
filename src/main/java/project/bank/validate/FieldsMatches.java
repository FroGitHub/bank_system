package project.bank.validate;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = FieldsMatchesValidator.class)
@Target({ElementType.TYPE})
public @interface FieldsMatches {
    String message() default "Wrong repeat password";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    String[] fields();
}
