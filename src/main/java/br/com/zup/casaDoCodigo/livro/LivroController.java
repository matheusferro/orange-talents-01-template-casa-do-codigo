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

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/livro")
public class LivroController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private LivroRepository livroRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<?> cadastrar(@RequestBody @Valid LivroForm form){
        Optional<Categoria> optCategoria = categoriaRepository.findByNome(form.getNomeCategoria());
        Optional<Autor> optAutor = autorRepository.findByEmail(form.getEmailAutor());

        livroRepository.save(form.converterToLivro(optCategoria.get(), optAutor.get()));
        return ResponseEntity.ok().build();
    }
}
