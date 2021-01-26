package br.com.zup.casaDoCodigo.autor;

import br.com.zup.casaDoCodigo.autor.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {

}
