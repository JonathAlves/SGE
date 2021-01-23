package com.basis.sge.service.servico.mapper;

import com.basis.sge.service.dominio.InscricaoResposta;
import com.basis.sge.service.servico.dto.InscricaoRespostaDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-01-23T20:19:05-0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_275 (Private Build)"
)
@Component
public class InscricaoRespostaMapperImpl implements InscricaoRespostaMapper {

    @Override
    public InscricaoResposta toEntity(InscricaoRespostaDTO dto) {
        if ( dto == null ) {
            return null;
        }

        InscricaoResposta inscricaoResposta = new InscricaoResposta();

        inscricaoResposta.setResposta( dto.getResposta() );
        inscricaoResposta.setInscricao( dto.getInscricao() );
        inscricaoResposta.setEvento( dto.getEvento() );
        inscricaoResposta.setPergunta( dto.getPergunta() );

        return inscricaoResposta;
    }

    @Override
    public InscricaoRespostaDTO toDto(InscricaoResposta entity) {
        if ( entity == null ) {
            return null;
        }

        InscricaoRespostaDTO inscricaoRespostaDTO = new InscricaoRespostaDTO();

        inscricaoRespostaDTO.setEvento( entity.getEvento() );
        inscricaoRespostaDTO.setPergunta( entity.getPergunta() );
        inscricaoRespostaDTO.setInscricao( entity.getInscricao() );
        inscricaoRespostaDTO.setResposta( entity.getResposta() );

        return inscricaoRespostaDTO;
    }

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
}
