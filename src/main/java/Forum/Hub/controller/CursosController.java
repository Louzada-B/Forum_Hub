package Forum.Hub.controller;

import Forum.Hub.domain.curso.CursoRepository;
import Forum.Hub.domain.curso.DadosCadastramentoCurso;
import Forum.Hub.domain.curso.DadosDetalhamentoCurso;
import Forum.Hub.domain.curso.RegistrarCurso;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cursos")
@SecurityRequirement(name = "bearer-key")
public class CursosController {

    private final RegistrarCurso registrarCurso;
    private final CursoRepository repository;

    public CursosController(RegistrarCurso registrarCurso, CursoRepository cursoRepository) {
        this.registrarCurso = registrarCurso;
        this.repository = cursoRepository;
    }

    @PostMapping()
    @Transactional
    public ResponseEntity<DadosDetalhamentoCurso> cadastrarCurso(@RequestBody @Valid DadosCadastramentoCurso dados) {
        System.out.println(dados);
        var curso = registrarCurso.registrarNovoCurso(dados);
        return ResponseEntity.ok(new DadosDetalhamentoCurso(curso));
    }

    @GetMapping
    public ResponseEntity<Page<DadosDetalhamentoCurso>> listarCurso(@PageableDefault(sort = {"nome"}) Pageable pagina)  {
        var cursos = repository.findAll(pagina).map(DadosDetalhamentoCurso::new);
        return ResponseEntity.ok(cursos);
    }
}
