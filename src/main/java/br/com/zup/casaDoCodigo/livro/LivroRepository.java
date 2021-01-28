package br.com.zup.casaDoCodigo.livro;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LivroRepository extends JpaRepository<Livro, Long> {

    @Query(value = "SELECT new br.com.zup.casaDoCodigo.livro.DetalhesLivroResponse(l.titulo, l.resumo, l.sumario, l.preco, l.numPaginas, l.isbn, l.dataPublicacao, a.nome, a.descricao) FROM Livro l JOIN l.autor a WHERE l.id = :pId", nativeQuery = false)
    DetalhesLivroResponse detalhesPorId(Long pId);
}
