package br.com.zup.casaDoCodigo.anotacao;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Anotacao para utilizar na validacao de unicidade de camos.
 *
 * @param domainClass
 * @param fieldName
 * @author Matheus Ferro
 * @since 1.0
 */
@Documented
@Constraint(validatedBy = {UniqueValueValidator.class })
@Target({FIELD})
@Retention(RUNTIME)
public @interface UniqueValue {

    Class<?> domainClass();

    String fieldName();

    String message() default "";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
