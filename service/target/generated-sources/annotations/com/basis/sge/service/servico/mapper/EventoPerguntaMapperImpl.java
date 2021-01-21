package com.basis.sge.service.servico.mapper;

import com.basis.sge.service.dominio.EventoPergunta;
import com.basis.sge.service.servico.dto.EventoPerguntaDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-01-21T15:40:35-0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_275 (Private Build)"
)
public class EventoPerguntaMapperImpl implements EventoPerguntaMapper {

    @Override
    public EventoPergunta toEntity(EventoPerguntaDTO dto) {
        if ( dto == null ) {
            return null;
        }

        EventoPergunta eventoPergunta = new EventoPergunta();

        eventoPergunta.setEvento( dto.getEvento() );
        eventoPergunta.setPergunta( dto.getPergunta() );

        return eventoPergunta;
    }

    @Override
    public EventoPerguntaDTO toDto(EventoPergunta entity) {
        if ( entity == null ) {
            return null;
        }

        EventoPerguntaDTO eventoPerguntaDTO = new EventoPerguntaDTO();

        eventoPerguntaDTO.setEvento( entity.getEvento() );
        eventoPerguntaDTO.setPergunta( entity.getPergunta() );

        return eventoPerguntaDTO;
    }

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
}
