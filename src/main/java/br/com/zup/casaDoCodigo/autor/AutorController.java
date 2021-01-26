package br.com.zup.casaDoCodigo.autor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/autor")
public class AutorController {

    @Autowired
    private AutorRepository autorRepository;

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody @Valid AutorForm form){
        autorRepository.save(form.converterToAutor());
        return ResponseEntity.ok().build();
    }
}
