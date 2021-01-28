package br.com.zup.casaDoCodigo.livro;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/**
 * Adicionado um novo controller, para termos controllers 100% coesos.
 */
@RestController
public class ListaLivroController {
    
    @Autowired
    private LivroRepository livroRepository;

    /**
     * Adicionado paginação para um retorno mais organizado.
     * Size default = 10
     */
    @GetMapping(path = "/livro")
    public Page<ListaLivrosResponse> visualizar(@PageableDefault(sort = "id", direction = Sort.Direction.ASC)
                                                        Pageable paginacao){
        Page<Livro> livrosCadastrados= livroRepository.findAll(paginacao);

        return ListaLivrosResponse.convertToLivroResponse(livrosCadastrados);
    }

    /**
     *  Após ver a resolução do Alberto decidi refatorar.
     *  Ainda utilizando o repository, agora sem metodo com JPQL,
     *  o construtor recebendo somente 1 parametro do tipo Livro,
     *  adicionado uma classe para tratar os dados do Autor
     *  e adicionado os getters necessarios.
     */
    @GetMapping(path = "/livro/{id}")
    public ResponseEntity<DetalhesLivroResponse> detalhes(@PathVariable("id") Long id){
        Optional<Livro> livro = livroRepository.findById(id);
        if(livro.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        DetalhesLivroResponse detalhesLivro = new DetalhesLivroResponse(livro.get());
        return ResponseEntity.ok(detalhesLivro);
    }
}
