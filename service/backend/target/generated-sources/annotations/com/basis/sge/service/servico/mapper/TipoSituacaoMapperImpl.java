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
    date = "2021-01-29T16:38:22-0300",
=======
    date = "2021-01-30T15:35:07-0300",
>>>>>>> 3d5ddd2c1a7abd71d6f5d435b26bbf0bae1e51ee
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_275 (Private Build)"
)
@Component
public class TipoSituacaoMapperImpl implements TipoSituacaoMapper {

    @Override
    public List<TipoSituacao> toEntity(List<TipoSituacaoDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<TipoSituacao> list = new ArrayList<TipoSituacao>( dtoList.size() );
        for ( TipoSituacaoDTO tipoSituacaoDTO : dtoList ) {
            list.add( toEntity( tipoSituacaoDTO ) );
        }

        return list;
    }

    @Override
    public List<TipoSituacaoDTO> toDto(List<TipoSituacao> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<TipoSituacaoDTO> list = new ArrayList<TipoSituacaoDTO>( entityList.size() );
        for ( TipoSituacao tipoSituacao : entityList ) {
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
