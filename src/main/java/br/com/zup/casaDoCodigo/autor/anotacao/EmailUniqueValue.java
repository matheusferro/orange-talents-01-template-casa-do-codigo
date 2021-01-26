package br.com.zup.casaDoCodigo.autor.anotacao;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = {EmailUniqueValueValidator.class })
@Target({ FIELD, PARAMETER})
@Retention(RUNTIME)
public @interface EmailUniqueValue {
    String message() default "E-mail já existente.";
    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
