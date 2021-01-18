package com.basis.sge.service.servico.mapper;

import com.basis.sge.service.dominio.Evento;
import com.basis.sge.service.servico.mapper.dto.EventoDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-01-17T23:12:31-0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.9.1 (Ubuntu)"
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
        evento.setDatahora_inicio( dto.getDatahora_inicio() );
        evento.setDatahora_final( dto.getDatahora_final() );
        evento.setDescricao( dto.getDescricao() );
        evento.setQuantidade_vaga( dto.getQuantidade_vaga() );
        evento.setValor( dto.getValor() );
        evento.setLocal_evento( dto.getLocal_evento() );
        evento.setTipo_inscricao( dto.getTipo_inscricao() );

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
        eventoDTO.setDatahora_inicio( entity.getDatahora_inicio() );
        eventoDTO.setDatahora_final( entity.getDatahora_final() );
        eventoDTO.setDescricao( entity.getDescricao() );
        eventoDTO.setQuantidade_vaga( entity.getQuantidade_vaga() );
        eventoDTO.setValor( entity.getValor() );
        eventoDTO.setLocal_evento( entity.getLocal_evento() );
        eventoDTO.setTipo_inscricao( entity.getTipo_inscricao() );

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
}
