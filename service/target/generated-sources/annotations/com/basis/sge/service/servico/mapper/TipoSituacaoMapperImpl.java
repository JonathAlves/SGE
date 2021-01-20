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
    date = "2021-01-20T15:45:06-0300",
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
            return null;
        }

        TipoSituacaoDTO tipoSituacaoDTO = new TipoSituacaoDTO();

        tipoSituacaoDTO.setId( entity.getId() );
        tipoSituacaoDTO.setDescricao( entity.getDescricao() );

        return tipoSituacaoDTO;
    }

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
}
