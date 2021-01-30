package br.com.zup.casaDoCodigo.compra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/compra")
public class CompraController {

    @Autowired
    private ValidadorPaisEstado validadorPaisEstado;

    @InitBinder
    public void init(WebDataBinder binder){
        binder.addValidators(validadorPaisEstado);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<?> cadastroParcial(@RequestBody @Valid CompraParcialRequest compraParcialRequest){
        return ResponseEntity.ok().body(compraParcialRequest);
    }
}
