package com.basis.sge.service.servico.mapper;

import com.basis.sge.service.dominio.Evento;
import com.basis.sge.service.dominio.Inscricao;
import com.basis.sge.service.dominio.InscricaoResposta;
import com.basis.sge.service.dominio.Pergunta;
import com.basis.sge.service.servico.dto.InscricaoRespostaDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
<<<<<<< HEAD
    date = "2021-01-29T14:01:44-0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_275 (Private Build)"
=======
<<<<<<< HEAD
    date = "2021-01-25T14:33:28-0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.9.1 (Ubuntu)"
=======
    date = "2021-01-28T22:37:04-0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_275 (Private Build)"
>>>>>>> 62b7406a3988ee19d1ca6f30df7fe966aca0ad16
>>>>>>> 31c54247e79c9a0dcf0253f8994cf6aaeb289717
)
@Component
public class InscricaoRespostaMapperImpl implements InscricaoRespostaMapper {

    @Override
    public List<InscricaoResposta> toEntity(List<InscricaoRespostaDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<InscricaoResposta> list = new ArrayList<InscricaoResposta>( dtoList.size() );
        for ( InscricaoRespostaDTO inscricaoRespostaDTO : dtoList ) {
            list.add( toEntity( inscricaoRespostaDTO ) );
        }

        return list;
    }

    @Override
    public List<InscricaoRespostaDTO> toDto(List<InscricaoResposta> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<InscricaoRespostaDTO> list = new ArrayList<InscricaoRespostaDTO>( entityList.size() );
        for ( InscricaoResposta inscricaoResposta : entityList ) {
            list.add( toDto( inscricaoResposta ) );
        }

        return list;
    }

    @Override
    public InscricaoResposta toEntity(InscricaoRespostaDTO inscricaoRespostaDTO) {
        if ( inscricaoRespostaDTO == null ) {
            return null;
        }

        InscricaoResposta inscricaoResposta = new InscricaoResposta();

        inscricaoResposta.setInscricao( inscricaoRespostaDTOToInscricao( inscricaoRespostaDTO ) );
        inscricaoResposta.setEvento( inscricaoRespostaDTOToEvento( inscricaoRespostaDTO ) );
        inscricaoResposta.setPergunta( inscricaoRespostaDTOToPergunta( inscricaoRespostaDTO ) );
        inscricaoResposta.setId( inscricaoRespostaDTO.getId() );
        inscricaoResposta.setResposta( inscricaoRespostaDTO.getResposta() );

        return inscricaoResposta;
    }

    @Override
    public InscricaoRespostaDTO toDto(InscricaoResposta inscricaoResposta) {
        if ( inscricaoResposta == null ) {
            return null;
        }

        InscricaoRespostaDTO inscricaoRespostaDTO = new InscricaoRespostaDTO();

        inscricaoRespostaDTO.setIdPergunta( inscricaoRespostaPerguntaId( inscricaoResposta ) );
        inscricaoRespostaDTO.setIdInscricao( inscricaoRespostaInscricaoId( inscricaoResposta ) );
        inscricaoRespostaDTO.setIdEvento( inscricaoRespostaEventoId( inscricaoResposta ) );
        inscricaoRespostaDTO.setId( inscricaoResposta.getId() );
        inscricaoRespostaDTO.setResposta( inscricaoResposta.getResposta() );

        return inscricaoRespostaDTO;
    }

    protected Inscricao inscricaoRespostaDTOToInscricao(InscricaoRespostaDTO inscricaoRespostaDTO) {
        if ( inscricaoRespostaDTO == null ) {
            return null;
        }

        Inscricao inscricao = new Inscricao();

        inscricao.setId( inscricaoRespostaDTO.getIdInscricao() );

        return inscricao;
    }

    protected Evento inscricaoRespostaDTOToEvento(InscricaoRespostaDTO inscricaoRespostaDTO) {
        if ( inscricaoRespostaDTO == null ) {
            return null;
        }

        Evento evento = new Evento();

        evento.setId( inscricaoRespostaDTO.getIdEvento() );

        return evento;
    }

    protected Pergunta inscricaoRespostaDTOToPergunta(InscricaoRespostaDTO inscricaoRespostaDTO) {
        if ( inscricaoRespostaDTO == null ) {
            return null;
        }

        Pergunta pergunta = new Pergunta();

        pergunta.setId( inscricaoRespostaDTO.getIdPergunta() );

        return pergunta;
    }

    private Integer inscricaoRespostaPerguntaId(InscricaoResposta inscricaoResposta) {
        if ( inscricaoResposta == null ) {
            return null;
        }
        Pergunta pergunta = inscricaoResposta.getPergunta();
        if ( pergunta == null ) {
            return null;
        }
        Integer id = pergunta.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Integer inscricaoRespostaInscricaoId(InscricaoResposta inscricaoResposta) {
        if ( inscricaoResposta == null ) {
            return null;
        }
        Inscricao inscricao = inscricaoResposta.getInscricao();
        if ( inscricao == null ) {
            return null;
        }
        Integer id = inscricao.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Integer inscricaoRespostaEventoId(InscricaoResposta inscricaoResposta) {
        if ( inscricaoResposta == null ) {
            return null;
        }
        Evento evento = inscricaoResposta.getEvento();
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
