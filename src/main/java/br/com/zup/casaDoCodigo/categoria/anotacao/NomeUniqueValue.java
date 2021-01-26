package br.com.zup.casaDoCodigo.categoria.anotacao;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = {NomeUniqueValueValidator.class })
@Target({FIELD, PARAMETER})
@Retention(RUNTIME)
public @interface NomeUniqueValue {
    String message() default "Nome de categoria já existente.";
    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
