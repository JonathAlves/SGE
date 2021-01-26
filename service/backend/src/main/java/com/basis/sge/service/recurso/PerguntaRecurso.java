package com.basis.sge.service.recurso;

import com.basis.sge.service.servico.PerguntaServico;
import com.basis.sge.service.servico.dto.PerguntaDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api/perguntas")
@RequiredArgsConstructor
public class PerguntaRecurso {

    private final PerguntaServico perguntaServico;

    @GetMapping
    public ResponseEntity<List<PerguntaDTO>> listar(){
        return ResponseEntity.ok(perguntaServico.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PerguntaDTO> obterPorId(@PathVariable Integer id){
        PerguntaDTO perguntaDTO = perguntaServico.obterPorId(id);
        return ResponseEntity.ok(perguntaDTO);
    }

    @PostMapping
    public ResponseEntity<PerguntaDTO> salvar(@RequestBody PerguntaDTO perguntaDTO) throws URISyntaxException {
        PerguntaDTO perguntaDTOSalvo = perguntaServico.salvar(perguntaDTO);
        return ResponseEntity.created(new URI("/api/perguntas")).body(perguntaDTOSalvo);
    }

    @PutMapping
    public ResponseEntity<PerguntaDTO> editar(@RequestBody PerguntaDTO perguntaDTO){
        PerguntaDTO dto = perguntaServico.salvar(perguntaDTO);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping ("/{id}")
    public void remover(@PathVariable Integer id){
        perguntaServico.remover(id);

    }

}