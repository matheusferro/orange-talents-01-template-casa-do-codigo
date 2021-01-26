package br.com.zup.casaDoCodigo.autor.anotacao;

import br.com.zup.casaDoCodigo.autor.Autor;
import br.com.zup.casaDoCodigo.autor.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

public class EmailUniqueValueValidator implements ConstraintValidator<EmailUniqueValue, String> {

    @Autowired
    private AutorRepository autorRepository;

    @Override
    public void initialize(EmailUniqueValue constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        Optional<Autor> optionalAutor = autorRepository.findByEmail(value);
        if(optionalAutor.isPresent()){
            return false;
        }
        return true;
    }
}
