package com.basis.sge.service.builder;

import com.basis.sge.service.dominio.Evento;
import com.basis.sge.service.dominio.TipoEvento;
import com.basis.sge.service.servico.EventoServico;
import com.basis.sge.service.servico.dto.EventoDTO;
import com.basis.sge.service.servico.mapper.EventoMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

public class EventoBuilder extends ConstrutorDeEntidade<Evento> {

    @Autowired
    private EventoMapper eventoMapper;

    @Autowired
    private EventoServico eventoServico;

    @Override
    public Evento construirEntidade() throws ParseException {
        Evento evento = new Evento();
        evento.setTitulo("Show de Talentos");
        evento.setDataInicio(LocalDateTime.now());
        evento.setDataTermino(LocalDateTime.now());
        evento.setDescricao("Busca de talentos desconhecidos!");
        evento.setQtVagas(null);
        evento.setValor(null);
        evento.setLocal("Teatro Motiva");
        evento.setTipoInscricao(false);
        evento.setTipoEvento(new TipoEvento());
        evento.getTipoEvento().setId(1);
        return evento;
    }

    @Override
    protected Evento persistir(Evento entidade) {
        EventoDTO eventoDTO = eventoMapper.toDto(entidade);
        EventoDTO eventoSalvo = eventoServico.salvar(eventoDTO);
        return eventoMapper.toEntity(eventoSalvo);
    }

    @Override
    protected Collection<Evento> obterTodos() {
        List<EventoDTO> eventoDTOS = eventoServico.listar();
        return eventoMapper.toEntity(eventoDTOS);
    }

    @Override
    protected Evento obterPorId(Integer id) {
        EventoDTO eventoDTO = eventoServico.obterPorId(id);
        return eventoMapper.toEntity(eventoDTO);
    }
    protected void deletarPorId(Integer id){
        eventoServico.remover(id);
    }
}
