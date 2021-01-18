package com.basis.sge.service.servico;

import com.basis.sge.service.dominio.Evento;
import com.basis.sge.service.repositorio.EventoRepositorio;
import com.basis.sge.service.servico.exception.RegraNegocioException;
import com.basis.sge.service.servico.mapper.EventoMapper;
import com.basis.sge.service.servico.mapper.dto.EventoDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor

public class EventoServico {
    private final EventoRepositorio eventoRepositorio;

    private final EventoMapper eventoMapper;

    public List<EventoDTO> listar(){
        List<Evento> eventos = eventoRepositorio.findAll();
        return eventoMapper.toDto(eventos);
    }

    public EventoDTO obterPorId(Integer id) {
        Evento evento = eventoRepositorio.findById(id).orElseThrow(()
        -> new RegraNegocioException("Evento não encontrado!"));
        return eventoMapper.toDto(evento);
    }
    public EventoDTO salvar(EventoDTO eventoDTO) {
        Evento evento = eventoRepositorio.findByTitulo(eventoDTO.getTitulo());

        if(evento != null){
            throw new RegraNegocioException("O Evento já existe com esse titulo!");
        }
        eventoRepositorio.save(evento);
        return eventoMapper.toDto(evento);
    }
    public EventoDTO editar(EventoDTO eventoDTO) {
        Evento evento = eventoRepositorio.findByTitulo(eventoDTO.getTitulo());

        if(evento != null){
            throw new RegraNegocioException("O Evento já existe com esse titulo!");
        }
        eventoRepositorio.save(evento);
        return eventoMapper.toDto(evento);
    }
    public void remover(Integer id){
        Evento evento = eventoRepositorio.findById(id).orElseThrow(()
        -> new RegraNegocioException("Evento não exite!"));
        eventoRepositorio.deleteById(evento.getId());

    }
}
