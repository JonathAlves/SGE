package com.basis.sge.service.recurso;


import com.basis.sge.service.dominio.Inscricao;
import com.basis.sge.service.servico.InscricaoServico;
import com.basis.sge.service.servico.dto.InscricaoDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/api/inscricoes")
@RequiredArgsConstructor
public class InscricaoRecurso   {

    private final InscricaoServico inscricaoServico;


    @GetMapping
    public ResponseEntity<List<InscricaoDTO>> listar(){
        List list = inscricaoServico.listar();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity <InscricaoDTO> obterPorId(@PathVariable Integer id){
        InscricaoDTO inscricaoDTO = inscricaoServico.obterPorId(id);
        return ResponseEntity.ok(inscricaoDTO);
    }

    @PostMapping
    public ResponseEntity <InscricaoDTO> salvar(@RequestBody InscricaoDTO inscricaoDTO) throws URISyntaxException {
        InscricaoDTO inscricao = inscricaoServico.salvar(inscricaoDTO);
        return ResponseEntity.created(new URI("/api/inscricoes")).body(inscricao);
    }

    @PutMapping
    public ResponseEntity <InscricaoDTO> editar(@RequestBody InscricaoDTO inscricaoDTO){
        InscricaoDTO inscricao = inscricaoServico.editar(inscricaoDTO);
        return ResponseEntity.ok(inscricao);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Integer id){
        inscricaoServico.remover(id);
        return ResponseEntity.ok().build();
    }
}
