package com.basis.sge.service.servico.mapper;

import com.basis.sge.service.dominio.Evento;
import com.basis.sge.service.dominio.Inscricao;
import com.basis.sge.service.dominio.TipoSituacao;
import com.basis.sge.service.dominio.Usuario;
import com.basis.sge.service.servico.dto.InscricaoDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
<<<<<<< HEAD
    date = "2021-01-21T15:40:35-0300",
=======
<<<<<<< HEAD
    date = "2021-01-21T15:07:40-0300",
=======
    date = "2021-01-20T15:48:01-0300",
>>>>>>> 0fa98efb43e19289c6f62be56eb3651962aa84f8
>>>>>>> f3faba0148205cded612fae26d356fe6d7121dd6
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_275 (Private Build)"
)
@Component
public class InscricaoMapperImpl implements InscricaoMapper {

    @Override
    public List<Inscricao> toEntity(List<InscricaoDTO> arg0) {
        if ( arg0 == null ) {
            return null;
        }

        List<Inscricao> list = new ArrayList<Inscricao>( arg0.size() );
        for ( InscricaoDTO inscricaoDTO : arg0 ) {
            list.add( toEntity( inscricaoDTO ) );
        }

        return list;
    }

    @Override
    public List<InscricaoDTO> toDto(List<Inscricao> arg0) {
        if ( arg0 == null ) {
            return null;
        }

        List<InscricaoDTO> list = new ArrayList<InscricaoDTO>( arg0.size() );
        for ( Inscricao inscricao : arg0 ) {
            list.add( toDto( inscricao ) );
        }

        return list;
    }

    @Override
    public Inscricao toEntity(InscricaoDTO inscricaoDTO) {
        if ( inscricaoDTO == null ) {
            return null;
        }

        Inscricao inscricao = new Inscricao();

<<<<<<< HEAD
        inscricao.setId( dto.getId() );
=======
        inscricao.setTipoSituacao( inscricaoDTOToTipoSituacao( inscricaoDTO ) );
        inscricao.setUsuario( inscricaoDTOToUsuario( inscricaoDTO ) );
        inscricao.setEvento( inscricaoDTOToEvento( inscricaoDTO ) );
        inscricao.setId( inscricaoDTO.getId() );
>>>>>>> f3faba0148205cded612fae26d356fe6d7121dd6

        return inscricao;
    }

    @Override
    public InscricaoDTO toDto(Inscricao inscricao) {
        if ( inscricao == null ) {
            return null;
        }

        InscricaoDTO inscricaoDTO = new InscricaoDTO();

<<<<<<< HEAD
        inscricaoDTO.setId( entity.getId() );
=======
        inscricaoDTO.setIdTipoSituacao( inscricaoTipoSituacaoId( inscricao ) );
        inscricaoDTO.setIdUsuario( inscricaoUsuarioId( inscricao ) );
        inscricaoDTO.setIdEvento( inscricaoEventoId( inscricao ) );
        inscricaoDTO.setId( inscricao.getId() );
>>>>>>> f3faba0148205cded612fae26d356fe6d7121dd6

        return inscricaoDTO;
    }

    protected TipoSituacao inscricaoDTOToTipoSituacao(InscricaoDTO inscricaoDTO) {
        if ( inscricaoDTO == null ) {
            return null;
        }

        TipoSituacao tipoSituacao = new TipoSituacao();

        tipoSituacao.setId( inscricaoDTO.getIdTipoSituacao() );

        return tipoSituacao;
    }

    protected Usuario inscricaoDTOToUsuario(InscricaoDTO inscricaoDTO) {
        if ( inscricaoDTO == null ) {
            return null;
        }

        Usuario usuario = new Usuario();

        usuario.setId( inscricaoDTO.getIdUsuario() );

        return usuario;
    }

    protected Evento inscricaoDTOToEvento(InscricaoDTO inscricaoDTO) {
        if ( inscricaoDTO == null ) {
            return null;
        }

        Evento evento = new Evento();

        evento.setId( inscricaoDTO.getIdEvento() );

        return evento;
    }

    private Integer inscricaoTipoSituacaoId(Inscricao inscricao) {
        if ( inscricao == null ) {
            return null;
        }
        TipoSituacao tipoSituacao = inscricao.getTipoSituacao();
        if ( tipoSituacao == null ) {
            return null;
        }
        Integer id = tipoSituacao.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Integer inscricaoUsuarioId(Inscricao inscricao) {
        if ( inscricao == null ) {
            return null;
        }
        Usuario usuario = inscricao.getUsuario();
        if ( usuario == null ) {
            return null;
        }
        Integer id = usuario.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Integer inscricaoEventoId(Inscricao inscricao) {
        if ( inscricao == null ) {
            return null;
        }
        Evento evento = inscricao.getEvento();
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
