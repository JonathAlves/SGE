package com.basis.sge.service.servico.mapper;

import com.basis.sge.service.dominio.Pergunta;
import com.basis.sge.service.servico.dto.PerguntaDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-01-19T02:51:59-0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_275 (Private Build)"
)
@Component
public class PerguntaMapperImpl implements PerguntaMapper {

    @Override
    public Pergunta toEntity(PerguntaDTO arg0) {
        if ( arg0 == null ) {
            return null;
        }

        Pergunta pergunta = new Pergunta();

        pergunta.setId( arg0.getId() );
        pergunta.setTitulo( arg0.getTitulo() );

        return pergunta;
    }

    @Override
    public PerguntaDTO toDto(Pergunta arg0) {
        if ( arg0 == null ) {
            return null;
        }

        PerguntaDTO perguntaDTO = new PerguntaDTO();

        perguntaDTO.setId( arg0.getId() );
        perguntaDTO.setTitulo( arg0.getTitulo() );

        return perguntaDTO;
    }

    @Override
    public List<Pergunta> toEntity(List<PerguntaDTO> arg0) {
        if ( arg0 == null ) {
            return null;
        }

        List<Pergunta> list = new ArrayList<Pergunta>( arg0.size() );
        for ( PerguntaDTO perguntaDTO : arg0 ) {
            list.add( toEntity( perguntaDTO ) );
        }

        return list;
    }

    @Override
    public List<PerguntaDTO> toDto(List<Pergunta> arg0) {
        if ( arg0 == null ) {
            return null;
        }

        List<PerguntaDTO> list = new ArrayList<PerguntaDTO>( arg0.size() );
        for ( Pergunta pergunta : arg0 ) {
            list.add( toDto( pergunta ) );
        }

        return list;
    }
}
