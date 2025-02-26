package Forum.Hub.controller;

import Forum.Hub.infra.security.TokenService;
import Forum.Hub.domain.resposta.ArquivarResposta;
import Forum.Hub.domain.resposta.DadosDetalhamentoResposta;
import Forum.Hub.domain.resposta.RespostaRepository;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/respostas")
@SecurityRequirement(name = "bearer-key")
public class RespostaController {
    private final RespostaRepository respostaRepository;
    private final TokenService tokenService;
    private final ArquivarResposta arquivarResposta;

    @Autowired
    public RespostaController(RespostaRepository respostaRepository, TokenService tokenService, ArquivarResposta arquivarResposta) {
        this.respostaRepository = respostaRepository;
        this.tokenService = tokenService;
        this.arquivarResposta = arquivarResposta;
    }

    @GetMapping("{id}")
    public ResponseEntity<DadosDetalhamentoResposta> buscarRespostaPorId(@PathVariable Long id) {
        var resposta = respostaRepository.findByIdAndAtivoTrue(id);
        if (resposta == null) {
            throw new RuntimeException("Resposta não encontrada");
        }
        return ResponseEntity.ok(new DadosDetalhamentoResposta(resposta));
    }

    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity deletarResposta(@PathVariable Long id, @RequestHeader("Authorization") String token) {
        var emailDoSolicitante = tokenService.getSubject(token);
        arquivarResposta.arquivar(id, emailDoSolicitante);
        return ResponseEntity.noContent().build();
    }
}
