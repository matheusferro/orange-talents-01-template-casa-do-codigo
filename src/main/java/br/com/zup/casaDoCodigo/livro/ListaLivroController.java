package br.com.zup.casaDoCodigo.livro;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
