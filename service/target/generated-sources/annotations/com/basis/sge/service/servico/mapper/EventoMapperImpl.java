package com.basis.sge.service.servico.mapper;

import com.basis.sge.service.dominio.Evento;
<<<<<<< HEAD
import com.basis.sge.service.dominio.TipoEvento;
=======
import com.basis.sge.service.dominio.EventoPergunta;
>>>>>>> 51bef42067148ae8ea03b4ee204ef80a18f8fbf9
import com.basis.sge.service.servico.dto.EventoDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
<<<<<<< HEAD
    date = "2021-01-20T15:45:06-0300",
=======
<<<<<<< HEAD
    date = "2021-01-20T14:38:34-0300",
=======
    date = "2021-01-19T16:46:15-0300",
>>>>>>> 51c233f465907d7461f9d5d781a4680b57f1e1e2
>>>>>>> 51bef42067148ae8ea03b4ee204ef80a18f8fbf9
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

<<<<<<< HEAD
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
=======
        eventoDTO.setId( entity.getId() );
        eventoDTO.setTitulo( entity.getTitulo() );
        eventoDTO.setDescricao( entity.getDescricao() );
        eventoDTO.setValor( entity.getValor() );
        eventoDTO.setTipoInscricao( entity.getTipoInscricao() );
        eventoDTO.setPerguntas( eventoPerguntaListToEventoPerguntaDTOList( entity.getPerguntas() ) );
>>>>>>> 51bef42067148ae8ea03b4ee204ef80a18f8fbf9

        return eventoDTO;
    }

    @Override
    public List<Evento> toEntity(List<EventoDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

<<<<<<< HEAD
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
=======
        List<Evento> list = new ArrayList<Evento>( dtoList.size() );
        for ( EventoDTO eventoDTO : dtoList ) {
            list.add( toEntity( eventoDTO ) );
        }
>>>>>>> 51bef42067148ae8ea03b4ee204ef80a18f8fbf9

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

<<<<<<< HEAD
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
=======
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
>>>>>>> 51bef42067148ae8ea03b4ee204ef80a18f8fbf9
    }
}
