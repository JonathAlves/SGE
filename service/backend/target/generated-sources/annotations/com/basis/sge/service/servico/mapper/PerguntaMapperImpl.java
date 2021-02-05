package com.basis.sge.service.servico.mapper;

import com.basis.sge.service.dominio.Pergunta;
import com.basis.sge.service.servico.dto.PerguntaDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-02-05T15:17:27-0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_275 (Private Build)"
)
@Component
public class PerguntaMapperImpl implements PerguntaMapper {

    @Override
    public Pergunta toEntity(PerguntaDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Pergunta pergunta = new Pergunta();

        pergunta.setId( dto.getId() );
        pergunta.setTitulo( dto.getTitulo() );
        pergunta.setObrigatoriedade( dto.getObrigatoriedade() );

        return pergunta;
    }

    @Override
    public PerguntaDTO toDto(Pergunta entity) {
        if ( entity == null ) {
            return null;
        }

        PerguntaDTO perguntaDTO = new PerguntaDTO();

        perguntaDTO.setId( entity.getId() );
        perguntaDTO.setTitulo( entity.getTitulo() );
        perguntaDTO.setObrigatoriedade( entity.getObrigatoriedade() );

        return perguntaDTO;
    }

    @Override
    public List<Pergunta> toEntity(List<PerguntaDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Pergunta> list = new ArrayList<Pergunta>( dtoList.size() );
        for ( PerguntaDTO perguntaDTO : dtoList ) {
            list.add( toEntity( perguntaDTO ) );
        }

        return list;
    }

    @Override
    public List<PerguntaDTO> toDto(List<Pergunta> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<PerguntaDTO> list = new ArrayList<PerguntaDTO>( entityList.size() );
        for ( Pergunta pergunta : entityList ) {
            list.add( toDto( pergunta ) );
        }

        return list;
    }
}
