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
    date = "2021-01-19T23:38:29-0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_275 (Private Build)"
)
@Component
public class EventoMapperImpl implements EventoMapper {

    @Override
    public Evento toEntity(EventoDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Evento evento = new Evento();

        evento.setId( dto.getId() );
        evento.setTitulo( dto.getTitulo() );
        evento.setDescricao( dto.getDescricao() );
        evento.setValor( dto.getValor() );
        evento.setTipoInscricao( dto.getTipoInscricao() );
        evento.setPerguntas( eventoPerguntaDTOListToEventoPerguntaList( dto.getPerguntas() ) );

        return evento;
    }

    @Override
    public EventoDTO toDto(Evento entity) {
        if ( entity == null ) {
            return null;
        }

        EventoDTO eventoDTO = new EventoDTO();

        eventoDTO.setId( entity.getId() );
        eventoDTO.setTitulo( entity.getTitulo() );
        eventoDTO.setDescricao( entity.getDescricao() );
        eventoDTO.setValor( entity.getValor() );
        eventoDTO.setTipoInscricao( entity.getTipoInscricao() );
        eventoDTO.setPerguntas( eventoPerguntaListToEventoPerguntaDTOList( entity.getPerguntas() ) );

        return eventoDTO;
    }

    @Override
    public List<Evento> toEntity(List<EventoDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Evento> list = new ArrayList<Evento>( dtoList.size() );
        for ( EventoDTO eventoDTO : dtoList ) {
            list.add( toEntity( eventoDTO ) );
        }

        return list;
    }

    @Override
    public List<EventoDTO> toDto(List<Evento> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<EventoDTO> list = new ArrayList<EventoDTO>( entityList.size() );
        for ( Evento evento : entityList ) {
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
