package br.com.zup.casaDoCodigo.categoria.anotacao;

import br.com.zup.casaDoCodigo.categoria.Categoria;
import br.com.zup.casaDoCodigo.categoria.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

public class NomeUniqueValueValidator implements ConstraintValidator<NomeUniqueValue, String> {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public void initialize(NomeUniqueValue constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        Optional<Categoria> optionalCategoria = categoriaRepository.findByNome(value);
        if(optionalCategoria.isPresent()){
            return false;
        }
        return true;
    }
}
