package com.basis.sge.service.recurso;

import com.basis.sge.service.servico.EventoServico;
import com.basis.sge.service.servico.dto.EventoDTO;
import com.basis.sge.service.servico.dto.UsuarioDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api/eventos")
@RequiredArgsConstructor
public class EventoRecurso {
    @Autowired
    private final EventoServico eventoServico;

    @GetMapping
    public ResponseEntity<List<EventoDTO>> listar() {
        List<EventoDTO> list = eventoServico.listar();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventoDTO> obterPorId(@PathVariable Integer id) {

        return ResponseEntity.ok(eventoServico.obterPorId(id));
    }


    @PostMapping
    public ResponseEntity<EventoDTO> salvar(@RequestBody @Valid EventoDTO eventoDTO) {
        EventoDTO evento = eventoServico.salvar(eventoDTO);
        return ResponseEntity.created(URI.create("/api/eventos")).body(evento);
    }

    @PutMapping
    public ResponseEntity<EventoDTO> editar(@RequestBody @Valid EventoDTO eventoDTO) {
        EventoDTO entidade = eventoServico.editar(eventoDTO);
        return ResponseEntity.ok(entidade);
    }


    @DeleteMapping("/{id}")
    public void remover(@PathVariable Integer id) {
        eventoServico.remover(id);
    }
}
