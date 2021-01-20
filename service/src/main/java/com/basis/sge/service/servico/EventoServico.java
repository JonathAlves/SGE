package com.basis.sge.service.servico;

import com.basis.sge.service.dominio.Evento;
import com.basis.sge.service.repositorio.EventoRepositorio;
import com.basis.sge.service.servico.dto.EventoDTO;
import com.basis.sge.service.servico.mapper.EventoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class EventoServico {

    private final EventoRepositorio eventoRepositorio;
    private final EventoMapper eventoMapper;

    public List<EventoDTO> listar() {
        List<Evento> eventos = eventoRepositorio.findAll();
        return eventoMapper.toDto(eventos);
    }

    public EventoDTO obterPorId(Integer id) {
        Evento evento = obter(id);
        return eventoMapper.toDto(evento);
    }

    private Evento obter(Integer id) {
        return eventoRepositorio.findById(id)
                .orElseThrow(() -> new RegraNegocioException("Evento não encontrado"));
    }

    public EventoDTO salvar(EventoDTO eventoDTO) {
        Evento evento = eventoMapper.toEntity(eventoDTO);
        //evento.setChave(UUID.randomUUID().toString());
        eventoRepositorio.save(evento);
        return eventoMapper.toDto(evento);
    }

    public EventoDTO editar(EventoDTO eventoDTO) {
        Evento evento = eventoMapper.toEntity(eventoDTO);
        eventoRepositorio.save(evento);
        return eventoMapper.toDto(evento);
    }

    public void remover(Integer id) {
        Evento evento = obter(id);
        eventoRepositorio.delete(evento);
    }
}
