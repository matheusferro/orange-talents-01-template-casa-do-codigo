package br.com.zup.casaDoCodigo.categoria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<?> cadastrar(@RequestBody @Valid CategoriaForm form){
        /**
         * Retirando o metodo de converter para classe dominio de dentro do form, por ser classes bem simples.
         */
        Categoria categoria = new Categoria(form.getNome());
        categoriaRepository.save(categoria);
        return ResponseEntity.ok().body(categoria.toString());
    }
}
