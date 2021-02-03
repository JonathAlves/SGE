package com.basis.sge.service.servico.mapper;

import com.basis.sge.service.dominio.Evento;
import com.basis.sge.service.dominio.EventoPergunta;
import com.basis.sge.service.dominio.Pergunta;
import com.basis.sge.service.servico.dto.EventoPerguntaDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-02-03T14:46:44-0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_282 (Amazon.com Inc.)"
)
@Component
public class EventoPerguntaMapperImpl implements EventoPerguntaMapper {

    @Override
    public List<EventoPergunta> toEntity(List<EventoPerguntaDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<EventoPergunta> list = new ArrayList<EventoPergunta>( dtoList.size() );
        for ( EventoPerguntaDTO eventoPerguntaDTO : dtoList ) {
            list.add( toEntity( eventoPerguntaDTO ) );
        }

        return list;
    }

    @Override
    public List<EventoPerguntaDTO> toDto(List<EventoPergunta> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<EventoPerguntaDTO> list = new ArrayList<EventoPerguntaDTO>( entityList.size() );
        for ( EventoPergunta eventoPergunta : entityList ) {
            list.add( toDto( eventoPergunta ) );
        }

        return list;
    }

    @Override
    public EventoPergunta toEntity(EventoPerguntaDTO eventoPerguntaDTO) {
        if ( eventoPerguntaDTO == null ) {
            return null;
        }

        EventoPergunta eventoPergunta = new EventoPergunta();

        eventoPergunta.setEvento( eventoPerguntaDTOToEvento( eventoPerguntaDTO ) );
        eventoPergunta.setPergunta( eventoPerguntaDTOToPergunta( eventoPerguntaDTO ) );
        eventoPergunta.setId( eventoPerguntaDTO.getId() );

        return eventoPergunta;
    }

    @Override
    public EventoPerguntaDTO toDto(EventoPergunta eventoPergunta) {
        if ( eventoPergunta == null ) {
            return null;
        }

        EventoPerguntaDTO eventoPerguntaDTO = new EventoPerguntaDTO();

        eventoPerguntaDTO.setIdPergunta( eventoPerguntaPerguntaId( eventoPergunta ) );
        eventoPerguntaDTO.setIdEvento( eventoPerguntaEventoId( eventoPergunta ) );
        eventoPerguntaDTO.setId( eventoPergunta.getId() );

        return eventoPerguntaDTO;
    }

    protected Evento eventoPerguntaDTOToEvento(EventoPerguntaDTO eventoPerguntaDTO) {
        if ( eventoPerguntaDTO == null ) {
            return null;
        }

        Evento evento = new Evento();

        evento.setId( eventoPerguntaDTO.getIdEvento() );

        return evento;
    }

    protected Pergunta eventoPerguntaDTOToPergunta(EventoPerguntaDTO eventoPerguntaDTO) {
        if ( eventoPerguntaDTO == null ) {
            return null;
        }

        Pergunta pergunta = new Pergunta();

        pergunta.setId( eventoPerguntaDTO.getIdPergunta() );

        return pergunta;
    }

    private Integer eventoPerguntaPerguntaId(EventoPergunta eventoPergunta) {
        if ( eventoPergunta == null ) {
            return null;
        }
        Pergunta pergunta = eventoPergunta.getPergunta();
        if ( pergunta == null ) {
            return null;
        }
        Integer id = pergunta.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Integer eventoPerguntaEventoId(EventoPergunta eventoPergunta) {
        if ( eventoPergunta == null ) {
            return null;
        }
        Evento evento = eventoPergunta.getEvento();
        if ( evento == null ) {
            return null;
        }
        Integer id = evento.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
