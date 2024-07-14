package Forum.Hub.domain.resposta;

import Forum.Hub.infra.others.FormatadorData;

public record DadosDetalhamentoResposta(Long id, String conteudo, Long topico_id, String dataDeCriacao, String autor,
                                        String solucao) {
    public DadosDetalhamentoResposta(Resposta dados) {
        this(dados.getId(), dados.getConteudo(), dados.getTopico().getId(), FormatadorData.formatarData(dados.getDataDeCriacao()), dados.getAutor().getNome(), dados.getSolucao());
    }
}
