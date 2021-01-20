package com.basis.sge.service.servico.mapper;

import com.basis.sge.service.dominio.TipoSituacao;
import com.basis.sge.service.servico.dto.TipoSituacaoDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-01-20T12:50:42-0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_275 (Private Build)"
)
@Component
public class TipoSituacaoMapperImpl implements TipoSituacaoMapper {

    @Override
    public TipoSituacao toEntity(TipoSituacaoDTO arg0) {
        if ( arg0 == null ) {
            return null;
        }

        TipoSituacao tipoSituacao = new TipoSituacao();

        tipoSituacao.setId( arg0.getId() );
        tipoSituacao.setDescricao( arg0.getDescricao() );

        return tipoSituacao;
    }

    @Override
    public TipoSituacaoDTO toDto(TipoSituacao arg0) {
        if ( arg0 == null ) {
            return null;
        }

        TipoSituacaoDTO tipoSituacaoDTO = new TipoSituacaoDTO();

        tipoSituacaoDTO.setId( arg0.getId() );
        tipoSituacaoDTO.setDescricao( arg0.getDescricao() );

        return tipoSituacaoDTO;
    }

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
}
