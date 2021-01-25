package com.basis.sge.service.builder;

import com.basis.sge.service.dominio.Evento;
import com.basis.sge.service.dominio.EventoPergunta;
import com.basis.sge.service.dominio.TipoEvento;
import com.basis.sge.service.repositorio.EventoRepositorio;
import com.basis.sge.service.servico.EventoServico;
import com.basis.sge.service.servico.dto.EventoDTO;
import com.basis.sge.service.servico.mapper.EventoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
@Component
public class EventoBuilder extends ConstrutorDeEntidade<Evento> {

    @Autowired
    private EventoMapper eventoMapper;

    @Autowired
    private EventoServico eventoServico;

    @Autowired
    private EventoRepositorio eventoRepositorio;

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
        TipoEvento tipoEvento = new TipoEvento();
        tipoEvento.setId(1);
        evento.setTipoEvento(tipoEvento);
        evento.setPerguntas(new ArrayList<EventoPergunta>());
        return evento;
    }

    @Override
    public Evento persistir(Evento entidade) {
        EventoDTO eventoDTO = eventoMapper.toDto(entidade);
        EventoDTO eventoSalvo = eventoServico.salvar(eventoDTO);
        return eventoMapper.toEntity(eventoSalvo);
    }

    @Override
    protected List<Evento> obterTodos() {

        return eventoRepositorio.findAll();
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
