package br.com.zup.casaDoCodigo.compra;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/compra")
public class CompraController {

    @PersistenceContext
    private EntityManager entityManager;

    @InitBinder
    public void init(WebDataBinder binder){
        binder.addValidators(new ValidadorPaisEstado(entityManager));
    }

    @PostMapping
    @Transactional
    public ResponseEntity<?> cadastroParcial(@RequestBody @Valid CompraParcialRequest compraParcialRequest){
        return ResponseEntity.ok().body(compraParcialRequest);
    }
}
