package br.com.zup.casaDoCodigo.livro;

import br.com.zup.casaDoCodigo.autor.Autor;
import br.com.zup.casaDoCodigo.autor.AutorRepository;
import br.com.zup.casaDoCodigo.categoria.Categoria;
import br.com.zup.casaDoCodigo.categoria.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/livro")
public class LivroController {

    /**
     * Após ver a solução do Alberto, decidi que  utilizar o EntityManager
     * será uma melhor escolha.
     */
    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping
    @Transactional
    public ResponseEntity<?> cadastrar(@RequestBody @Valid LivroForm form){
        Livro livro = form.converterToLivro(entityManager);
        entityManager.persist(livro);
        return ResponseEntity.ok().body(livro.toString());
    }
}
