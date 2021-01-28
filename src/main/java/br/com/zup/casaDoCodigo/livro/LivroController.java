package br.com.zup.casaDoCodigo.livro;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;


@RestController
public class LivroController {

    /**
     * Após ver a solução do Alberto, decidi que  utilizar o EntityManager
     * será uma melhor escolha.
     */
    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping(path = "/livro")
    @Transactional
    public ResponseEntity<?> cadastrar(@RequestBody @Valid LivroForm form){
        Livro livro = form.converterToLivro(entityManager);
        entityManager.persist(livro);
        return ResponseEntity.ok().body(livro.toString());
    }
}
