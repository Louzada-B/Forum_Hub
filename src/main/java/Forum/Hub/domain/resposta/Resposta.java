package Forum.Hub.domain.resposta;

import Forum.Hub.domain.topico.Topico;
import Forum.Hub.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity(name = "Resposta")
@Table(name = "respostas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Resposta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String conteudo;
    @ManyToOne
    private Topico topico;
    private LocalDateTime dataDeCriacao;
    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Usuario autor;
    private String solucao;
    private boolean ativo;

    public Resposta(String conteudo, Topico topico, Usuario autor) {
        this.id = null;
        this.conteudo = conteudo;
        this.topico = topico;
        this.dataDeCriacao = LocalDateTime.now();
        this.autor = autor;
        this.solucao = Solucao.SEM_RESPOSTA.toString();
        this.ativo = true;
    }

    public void excluirResposta() {
        this.ativo = false;
    }
}
