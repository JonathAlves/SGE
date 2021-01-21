package com.basis.sge.service.servico.mapper;

import com.basis.sge.service.dominio.Pergunta;
import com.basis.sge.service.servico.dto.PerguntaDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
<<<<<<< HEAD
    date = "2021-01-21T15:07:40-0300",
=======
<<<<<<< HEAD
    date = "2021-01-20T13:40:05-0300",
=======
<<<<<<< HEAD
    date = "2021-01-20T14:38:34-0300",
=======
    date = "2021-01-19T16:46:15-0300",
>>>>>>> 51c233f465907d7461f9d5d781a4680b57f1e1e2
>>>>>>> 51bef42067148ae8ea03b4ee204ef80a18f8fbf9
>>>>>>> 0fa98efb43e19289c6f62be56eb3651962aa84f8
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
