package Forum.Hub.domain.topico;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TopicoRepository extends JpaRepository<Topico, Long> {
    @Query("SELECT t FROM Topico t WHERE t.ativo ORDER BY t.dataDeCriacao ASC")
    Page<Topico> listar10UltimosTopicos(Pageable pagina);

    @Query("SELECT t FROM Topico t WHERE t.ativo AND LOWER(t.curso.nome) LIKE LOWER(CONCAT('%', :nomeCursoFormatado, '%')) AND YEAR(t.dataDeCriacao) = :anoFormatado")
    Page<Topico> listarTopicosPorCursoEAnoDeCriacao(String nomeCursoFormatado, Long anoFormatado, Pageable pagina);
}
