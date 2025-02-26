package Forum.Hub.domain.topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastramentoTopico(
        @NotBlank String titulo,
        @NotBlank String mensagem,
        @NotNull Long idCurso
        ) {
}
