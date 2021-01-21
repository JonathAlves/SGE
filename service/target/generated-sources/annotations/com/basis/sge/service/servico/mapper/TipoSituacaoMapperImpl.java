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
    date = "2021-01-21T15:40:34-0300",
=======
<<<<<<< HEAD
    date = "2021-01-21T15:07:40-0300",
=======
    date = "2021-01-20T15:48:02-0300",
>>>>>>> 0fa98efb43e19289c6f62be56eb3651962aa84f8
>>>>>>> f3faba0148205cded612fae26d356fe6d7121dd6
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_275 (Private Build)"
)
@Component
public class TipoSituacaoMapperImpl implements TipoSituacaoMapper {

    @Override
    public List<TipoSituacao> toEntity(List<TipoSituacaoDTO> arg0) {
        if ( arg0 == null ) {
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
}
