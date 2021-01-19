package com.basis.sge.service.servico.mapper;

import com.basis.sge.service.dominio.Inscricao;
import com.basis.sge.service.servico.dto.InscricaoDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-01-19T02:51:59-0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_275 (Private Build)"
)
@Component
public class InscricaoMapperImpl implements InscricaoMapper {

    @Override
    public InscricaoDTO toDto(Inscricao arg0) {
        if ( arg0 == null ) {
            return null;
        }

        InscricaoDTO inscricaoDTO = new InscricaoDTO();

        inscricaoDTO.setId( arg0.getId() );

        return inscricaoDTO;
    }

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

        inscricao.setIdEvento( inscricaoDTO.getId() );
        inscricao.setIdUsuario( inscricaoDTO.getId() );
        inscricao.setId( inscricaoDTO.getId() );

        return inscricao;
    }
}
