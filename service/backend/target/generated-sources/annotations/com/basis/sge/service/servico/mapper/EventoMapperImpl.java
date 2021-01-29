package com.basis.sge.service.servico.mapper;

import com.basis.sge.service.dominio.Evento;
import com.basis.sge.service.dominio.EventoPergunta;
import com.basis.sge.service.dominio.TipoEvento;
import com.basis.sge.service.servico.dto.EventoDTO;
import com.basis.sge.service.servico.dto.EventoPerguntaDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
<<<<<<< HEAD
    date = "2021-01-25T14:33:28-0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.9.1 (Ubuntu)"
=======
    date = "2021-01-28T22:37:04-0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_275 (Private Build)"
>>>>>>> 62b7406a3988ee19d1ca6f30df7fe966aca0ad16
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
        evento.setPerguntas( eventoPerguntaDTOListToEventoPerguntaList( eventoDTO.getPerguntas() ) );

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
        eventoDTO.setPerguntas( eventoPerguntaListToEventoPerguntaDTOList( evento.getPerguntas() ) );

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
