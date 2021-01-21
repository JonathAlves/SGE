package com.basis.sge.service.servico.mapper;

import com.basis.sge.service.dominio.Evento;
import com.basis.sge.service.dominio.EventoPergunta;
import com.basis.sge.service.servico.dto.EventoDTO;
import com.basis.sge.service.servico.dto.EventoPerguntaDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-01-20T15:48:02-0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_275 (Private Build)"
)
@Component
public class EventoMapperImpl implements EventoMapper {

    @Override
    public Evento toEntity(EventoDTO arg0) {
        if ( arg0 == null ) {
            return null;
        }

        Evento evento = new Evento();

        evento.setId( arg0.getId() );
        evento.setTitulo( arg0.getTitulo() );
        evento.setDescricao( arg0.getDescricao() );
        evento.setValor( arg0.getValor() );
        evento.setTipoInscricao( arg0.getTipoInscricao() );
        evento.setPerguntas( eventoPerguntaDTOListToEventoPerguntaList( arg0.getPerguntas() ) );

        return evento;
    }

    @Override
    public EventoDTO toDto(Evento arg0) {
        if ( arg0 == null ) {
            return null;
        }

        EventoDTO eventoDTO = new EventoDTO();

        eventoDTO.setId( arg0.getId() );
        eventoDTO.setTitulo( arg0.getTitulo() );
        eventoDTO.setDescricao( arg0.getDescricao() );
        eventoDTO.setValor( arg0.getValor() );
        eventoDTO.setTipoInscricao( arg0.getTipoInscricao() );
        eventoDTO.setPerguntas( eventoPerguntaListToEventoPerguntaDTOList( arg0.getPerguntas() ) );

        return eventoDTO;
    }

    @Override
    public List<Evento> toEntity(List<EventoDTO> arg0) {
        if ( arg0 == null ) {
            return null;
        }

        List<Evento> list = new ArrayList<Evento>( arg0.size() );
        for ( EventoDTO eventoDTO : arg0 ) {
            list.add( toEntity( eventoDTO ) );
        }

        return list;
    }

    @Override
    public List<EventoDTO> toDto(List<Evento> arg0) {
        if ( arg0 == null ) {
            return null;
        }

        List<EventoDTO> list = new ArrayList<EventoDTO>( arg0.size() );
        for ( Evento evento : arg0 ) {
            list.add( toDto( evento ) );
        }

        return list;
    }

    protected EventoPergunta eventoPerguntaDTOToEventoPergunta(EventoPerguntaDTO eventoPerguntaDTO) {
        if ( eventoPerguntaDTO == null ) {
            return null;
        }

        EventoPergunta eventoPergunta = new EventoPergunta();

        eventoPergunta.setId( eventoPerguntaDTO.getId() );
        eventoPergunta.setEvento( eventoPerguntaDTO.getEvento() );
        eventoPergunta.setPergunta( eventoPerguntaDTO.getPergunta() );

        return eventoPergunta;
    }

    protected List<EventoPergunta> eventoPerguntaDTOListToEventoPerguntaList(List<EventoPerguntaDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<EventoPergunta> list1 = new ArrayList<EventoPergunta>( list.size() );
        for ( EventoPerguntaDTO eventoPerguntaDTO : list ) {
            list1.add( eventoPerguntaDTOToEventoPergunta( eventoPerguntaDTO ) );
        }

        return list1;
    }

    protected EventoPerguntaDTO eventoPerguntaToEventoPerguntaDTO(EventoPergunta eventoPergunta) {
        if ( eventoPergunta == null ) {
            return null;
        }

        EventoPerguntaDTO eventoPerguntaDTO = new EventoPerguntaDTO();

        eventoPerguntaDTO.setId( eventoPergunta.getId() );
        eventoPerguntaDTO.setEvento( eventoPergunta.getEvento() );
        eventoPerguntaDTO.setPergunta( eventoPergunta.getPergunta() );

        return eventoPerguntaDTO;
    }

    protected List<EventoPerguntaDTO> eventoPerguntaListToEventoPerguntaDTOList(List<EventoPergunta> list) {
        if ( list == null ) {
            return null;
        }

        List<EventoPerguntaDTO> list1 = new ArrayList<EventoPerguntaDTO>( list.size() );
        for ( EventoPergunta eventoPergunta : list ) {
            list1.add( eventoPerguntaToEventoPerguntaDTO( eventoPergunta ) );
        }

        return list1;
    }
}
