package com.basis.sge.service.recurso;


import com.basis.sge.service.servico.InscricaoServico;
import com.basis.sge.service.servico.dto.InscricaoDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

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

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Integer id){
        inscricaoServico.remover(id);
    }
}
