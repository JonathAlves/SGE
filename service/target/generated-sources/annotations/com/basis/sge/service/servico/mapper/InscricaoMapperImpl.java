package com.basis.sge.service.servico.mapper;

import com.basis.sge.service.dominio.Inscricao;
import com.basis.sge.service.servico.dto.InscricaoDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
<<<<<<< HEAD
    date = "2021-01-18T23:49:09-0300",
=======
    date = "2021-01-18T17:31:11-0300",
>>>>>>> d04482f3e87d59056340f4c4ef91b5dc378d0ae5
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_275 (Private Build)"
)
@Component
public class InscricaoMapperImpl implements InscricaoMapper {

    @Override
    public Inscricao toEntity(InscricaoDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Inscricao inscricao = new Inscricao();

        inscricao.setId( dto.getId() );
<<<<<<< HEAD
        inscricao.setIdUsuario( dto.getIdUsuario() );
=======
>>>>>>> d04482f3e87d59056340f4c4ef91b5dc378d0ae5

        return inscricao;
    }

    @Override
    public InscricaoDTO toDto(Inscricao entity) {
        if ( entity == null ) {
            return null;
        }

        InscricaoDTO inscricaoDTO = new InscricaoDTO();

        inscricaoDTO.setId( entity.getId() );
<<<<<<< HEAD
        inscricaoDTO.setIdUsuario( entity.getIdUsuario() );
=======
>>>>>>> d04482f3e87d59056340f4c4ef91b5dc378d0ae5

        return inscricaoDTO;
    }

    @Override
    public List<Inscricao> toEntity(List<InscricaoDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Inscricao> list = new ArrayList<Inscricao>( dtoList.size() );
        for ( InscricaoDTO inscricaoDTO : dtoList ) {
            list.add( toEntity( inscricaoDTO ) );
        }

        return list;
    }

    @Override
    public List<InscricaoDTO> toDto(List<Inscricao> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<InscricaoDTO> list = new ArrayList<InscricaoDTO>( entityList.size() );
        for ( Inscricao inscricao : entityList ) {
            list.add( toDto( inscricao ) );
        }

        return list;
    }
}
