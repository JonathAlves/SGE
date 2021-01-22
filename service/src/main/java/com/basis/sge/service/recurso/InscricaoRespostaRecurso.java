package com.basis.sge.service.recurso;

import com.basis.sge.service.servico.InscricaoRespostaServico;
import com.basis.sge.service.servico.dto.InscricaoRespostaDTO;
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
@RequestMapping("/api/inscricao/resposta")
@RequiredArgsConstructor
public class InscricaoRespostaRecurso {

    private final InscricaoRespostaServico inscricaoRespostaServico;

    @GetMapping
    public ResponseEntity<List<InscricaoRespostaDTO>> listar(){
        List list = inscricaoRespostaServico.listar();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<InscricaoRespostaDTO> obterPorId(@PathVariable Integer Id){
        InscricaoRespostaDTO inscricaoRespostaDTO = inscricaoRespostaServico.obterPorId(Id);
        return ResponseEntity.ok(inscricaoRespostaDTO);
    }

    @PostMapping
    public ResponseEntity<InscricaoRespostaDTO> salvar(@RequestBody InscricaoRespostaDTO inscricaoRespostaDTO){
        InscricaoRespostaDTO inscricaoResposta = inscricaoRespostaServico.salvar(inscricaoRespostaDTO);
        return ResponseEntity.ok(inscricaoResposta);
    }

    //@PutMapping
    //public ResponseEntity<InscricaoRespostaDTO> editar(@PathVariable InscricaoRespostaDTO inscricaoRespostaDTO){
    //   inscricaoRespostaServico.obterPorId(inscricaoRespostaDTO.getId());
    //    InscricaoRespostaDTO dto = inscricaoRespostaServico.salvar(inscricaoRespostaDTO);
    //    return ResponseEntity.ok(inscricaoRespostaDTO);
    //}

    @DeleteMapping
    public ResponseEntity<InscricaoRespostaDTO> remover(@PathVariable Integer Id){
        inscricaoRespostaServico.remover(Id);
        return ResponseEntity.ok().build();
    }
}
