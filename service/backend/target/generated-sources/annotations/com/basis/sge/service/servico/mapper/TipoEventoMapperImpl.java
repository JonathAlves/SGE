package com.basis.sge.service.servico.mapper;

import com.basis.sge.service.dominio.TipoEvento;
import com.basis.sge.service.servico.dto.TipoEventoDTO;
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
public class TipoEventoMapperImpl implements TipoEventoMapper {

    @Override
    public TipoEvento toEntity(TipoEventoDTO dto) {
        if ( dto == null ) {
            return null;
        }

        TipoEvento tipoEvento = new TipoEvento();

        return tipoEvento;
    }

    @Override
    public TipoEventoDTO toDto(TipoEvento entity) {
        if ( entity == null ) {
            return null;
        }

        TipoEventoDTO tipoEventoDTO = new TipoEventoDTO();

        return tipoEventoDTO;
    }

    @Override
    public List<TipoEvento> toEntity(List<TipoEventoDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<TipoEvento> list = new ArrayList<TipoEvento>( dtoList.size() );
        for ( TipoEventoDTO tipoEventoDTO : dtoList ) {
            list.add( toEntity( tipoEventoDTO ) );
        }

        return list;
    }

    @Override
    public List<TipoEventoDTO> toDto(List<TipoEvento> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<TipoEventoDTO> list = new ArrayList<TipoEventoDTO>( entityList.size() );
        for ( TipoEvento tipoEvento : entityList ) {
            list.add( toDto( tipoEvento ) );
        }

        return list;
    }
}
