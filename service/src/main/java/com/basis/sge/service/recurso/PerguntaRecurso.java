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

import java.util.List;

@RestController
@RequestMapping("/api/perguntas")
@RequiredArgsConstructor
public class PerguntaRecurso {

    private final PerguntaServico perguntaServico;

    @GetMapping
    public ResponseEntity<List<PerguntaDTO>> listar(){
        List list = perguntaServico.listar();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PerguntaDTO> obterPorId(@PathVariable Integer Id){
        PerguntaDTO perguntaDTO = perguntaServico.obterPorId(Id);
        return ResponseEntity.ok(perguntaDTO);
    }

    @PostMapping
    public ResponseEntity<PerguntaDTO> salvar(@RequestBody PerguntaDTO perguntaDTO){
        PerguntaDTO pergunta = perguntaServico.salvar(perguntaDTO);
        return ResponseEntity.ok(pergunta);
    }

    @PutMapping
    public ResponseEntity<PerguntaDTO> editar(@PathVariable PerguntaDTO perguntaDTO){
        perguntaServico.obterPorId(perguntaDTO.getId());
        PerguntaDTO dto = perguntaServico.salvar(perguntaDTO);
        return ResponseEntity.ok(perguntaDTO);
    }

    @DeleteMapping
    public ResponseEntity<PerguntaDTO> remover(@PathVariable Integer Id){
        perguntaServico.remover(Id);
        return ResponseEntity.ok().build();
    }

}
