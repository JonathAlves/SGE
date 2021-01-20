package com.basis.sge.service.servico.mapper;

import com.basis.sge.service.dominio.TipoSituacao;
import com.basis.sge.service.servico.dto.TipoSituacaoDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
<<<<<<< HEAD
    date = "2021-01-20T15:19:03-0300",
=======
<<<<<<< HEAD
    date = "2021-01-20T14:38:33-0300",
=======
    date = "2021-01-19T16:46:14-0300",
>>>>>>> 51c233f465907d7461f9d5d781a4680b57f1e1e2
>>>>>>> 51bef42067148ae8ea03b4ee204ef80a18f8fbf9
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_275 (Private Build)"
)
@Component
public class TipoSituacaoMapperImpl implements TipoSituacaoMapper {

    @Override
<<<<<<< HEAD
    public List<TipoSituacao> toEntity(List<TipoSituacaoDTO> arg0) {
        if ( arg0 == null ) {
=======
    public TipoSituacao toEntity(TipoSituacaoDTO dto) {
        if ( dto == null ) {
            return null;
        }

        TipoSituacao tipoSituacao = new TipoSituacao();

        tipoSituacao.setId( dto.getId() );
        tipoSituacao.setDescricao( dto.getDescricao() );

        return tipoSituacao;
    }

    @Override
    public TipoSituacaoDTO toDto(TipoSituacao entity) {
        if ( entity == null ) {
>>>>>>> 51bef42067148ae8ea03b4ee204ef80a18f8fbf9
            return null;
        }

        List<TipoSituacao> list = new ArrayList<TipoSituacao>( arg0.size() );
        for ( TipoSituacaoDTO tipoSituacaoDTO : arg0 ) {
            list.add( toEntity( tipoSituacaoDTO ) );
        }

        return list;
    }

    @Override
    public List<TipoSituacaoDTO> toDto(List<TipoSituacao> arg0) {
        if ( arg0 == null ) {
            return null;
        }

        List<TipoSituacaoDTO> list = new ArrayList<TipoSituacaoDTO>( arg0.size() );
        for ( TipoSituacao tipoSituacao : arg0 ) {
            list.add( toDto( tipoSituacao ) );
        }

        return list;
    }
<<<<<<< HEAD

    @Override
    public TipoSituacao toEntity(TipoSituacaoDTO tipoSituacaoDTO) {
        if ( tipoSituacaoDTO == null ) {
            return null;
        }

        TipoSituacao tipoSituacao = new TipoSituacao();

        tipoSituacao.setId( tipoSituacaoDTO.getId() );
        tipoSituacao.setDescricao( tipoSituacaoDTO.getDescricao() );

        return tipoSituacao;
    }

    @Override
    public TipoSituacaoDTO toDto(TipoSituacao tipoSituacao) {
        if ( tipoSituacao == null ) {
            return null;
        }

        TipoSituacaoDTO tipoSituacaoDTO = new TipoSituacaoDTO();

        tipoSituacaoDTO.setId( tipoSituacao.getId() );
        tipoSituacaoDTO.setDescricao( tipoSituacao.getDescricao() );

        return tipoSituacaoDTO;
    }
=======
>>>>>>> 51bef42067148ae8ea03b4ee204ef80a18f8fbf9
}
