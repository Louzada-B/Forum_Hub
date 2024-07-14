package Forum.Hub.domain.topico;

import Forum.Hub.infra.others.FormatadorData;

public record DadosDetalhamentoTopico(
        Long id,
        String titulo,
        String mensagem,
        String dataDeCriacao,
        String autor,
        String curso) {
    public DadosDetalhamentoTopico(Topico dados) {
        this(
                dados.getId(),
                dados.getTitulo(),
                dados.getMensagem(),
                FormatadorData.formatarData(dados.getDataDeCriacao()),
                dados.getAutor().getNome(),
                dados.getCurso().getNome()
        );
    }
}
