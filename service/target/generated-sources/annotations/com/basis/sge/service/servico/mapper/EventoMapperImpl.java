package com.basis.sge.service.servico.mapper;

import com.basis.sge.service.dominio.Evento;
import com.basis.sge.service.dominio.TipoEvento;
import com.basis.sge.service.servico.dto.EventoDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-01-22T13:50:13-0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_275 (Private Build)"
)
@Component
public class EventoMapperImpl implements EventoMapper {

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

    @Override
    public Evento toEntity(EventoDTO eventoDTO) {
        if ( eventoDTO == null ) {
            return null;
        }

        Evento evento = new Evento();

        evento.setTipoEvento( eventoDTOToTipoEvento( eventoDTO ) );
        evento.setId( eventoDTO.getId() );
        evento.setTitulo( eventoDTO.getTitulo() );
        evento.setDataInicio( eventoDTO.getDataInicio() );
        evento.setDataTermino( eventoDTO.getDataTermino() );
        evento.setDescricao( eventoDTO.getDescricao() );
        evento.setQtVagas( eventoDTO.getQtVagas() );
        evento.setValor( eventoDTO.getValor() );
        evento.setLocal( eventoDTO.getLocal() );
        evento.setTipoInscricao( eventoDTO.getTipoInscricao() );

        return evento;
    }

    @Override
    public EventoDTO toDto(Evento evento) {
        if ( evento == null ) {
            return null;
        }

        EventoDTO eventoDTO = new EventoDTO();

        eventoDTO.setIdTipoEvento( eventoTipoEventoId( evento ) );
        eventoDTO.setId( evento.getId() );
        eventoDTO.setTitulo( evento.getTitulo() );
        eventoDTO.setDataInicio( evento.getDataInicio() );
        eventoDTO.setDataTermino( evento.getDataTermino() );
        eventoDTO.setDescricao( evento.getDescricao() );
        eventoDTO.setQtVagas( evento.getQtVagas() );
        eventoDTO.setValor( evento.getValor() );
        eventoDTO.setLocal( evento.getLocal() );
        eventoDTO.setTipoInscricao( evento.getTipoInscricao() );

        return eventoDTO;
    }

    protected TipoEvento eventoDTOToTipoEvento(EventoDTO eventoDTO) {
        if ( eventoDTO == null ) {
            return null;
        }

        TipoEvento tipoEvento = new TipoEvento();

        tipoEvento.setId( eventoDTO.getIdTipoEvento() );

        return tipoEvento;
    }

    private Integer eventoTipoEventoId(Evento evento) {
        if ( evento == null ) {
            return null;
        }
        TipoEvento tipoEvento = evento.getTipoEvento();
        if ( tipoEvento == null ) {
            return null;
        }
        Integer id = tipoEvento.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
