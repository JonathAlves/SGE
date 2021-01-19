package com.basis.sge.service.recurso;

import com.basis.sge.service.servico.EventoServico;
import com.basis.sge.service.servico.mapper.dto.EventoDTO;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/eventos")
@AllArgsConstructor
public class EventoRecurso {

    private final EventoServico eventoServico;

    @GetMapping
    public ResponseEntity<List<EventoDTO>> listar(){
        return ResponseEntity.ok(eventoServico.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventoDTO> obterPorId(@PathVariable Integer id) {
        EventoDTO entidadeDTO = eventoServico.obterPorId(id);
        return ResponseEntity.ok(entidadeDTO);
    }

    @PostMapping
    public ResponseEntity<EventoDTO> salvar(@RequestBody EventoDTO entidadeDTO) {
        EventoDTO entidade = eventoServico.salvar(entidadeDTO);
        return ResponseEntity.created(URI.create("/api/eventos")).body(entidade);
    }

    @PutMapping
    public ResponseEntity<EventoDTO> editar(@RequestBody EventoDTO entidadeDTO) {
        EventoDTO entidade = eventoServico.editar(entidadeDTO);
        return ok(entidade);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Integer id) {
        eventoServico.remover(id);
        return ok().build();
    }

}
