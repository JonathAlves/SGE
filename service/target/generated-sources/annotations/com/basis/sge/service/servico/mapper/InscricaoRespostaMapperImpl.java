package com.basis.sge.service.servico.mapper;

import com.basis.sge.service.dominio.InscricaoResposta;
import com.basis.sge.service.servico.dto.InscricaoRespostaDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-01-18T17:33:27-0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_275 (Private Build)"
)
@Component
public class InscricaoRespostaMapperImpl implements InscricaoRespostaMapper {

    @Override
    public InscricaoResposta toEntity(InscricaoRespostaDTO arg0) {
        if ( arg0 == null ) {
            return null;
        }

        InscricaoResposta inscricaoResposta = new InscricaoResposta();

        inscricaoResposta.setResposta( arg0.getResposta() );
        inscricaoResposta.setInscricao( arg0.getInscricao() );
        inscricaoResposta.setEvento( arg0.getEvento() );
        inscricaoResposta.setPergunta( arg0.getPergunta() );

        return inscricaoResposta;
    }

    @Override
    public InscricaoRespostaDTO toDto(InscricaoResposta arg0) {
        if ( arg0 == null ) {
            return null;
        }

        InscricaoRespostaDTO inscricaoRespostaDTO = new InscricaoRespostaDTO();

        inscricaoRespostaDTO.setEvento( arg0.getEvento() );
        inscricaoRespostaDTO.setPergunta( arg0.getPergunta() );
        inscricaoRespostaDTO.setInscricao( arg0.getInscricao() );
        inscricaoRespostaDTO.setResposta( arg0.getResposta() );

        return inscricaoRespostaDTO;
    }

    @Override
    public List<InscricaoResposta> toEntity(List<InscricaoRespostaDTO> arg0) {
        if ( arg0 == null ) {
            return null;
        }

        List<InscricaoResposta> list = new ArrayList<InscricaoResposta>( arg0.size() );
        for ( InscricaoRespostaDTO inscricaoRespostaDTO : arg0 ) {
            list.add( toEntity( inscricaoRespostaDTO ) );
        }

        return list;
    }

    @Override
    public List<InscricaoRespostaDTO> toDto(List<InscricaoResposta> arg0) {
        if ( arg0 == null ) {
            return null;
        }

        List<InscricaoRespostaDTO> list = new ArrayList<InscricaoRespostaDTO>( arg0.size() );
        for ( InscricaoResposta inscricaoResposta : arg0 ) {
            list.add( toDto( inscricaoResposta ) );
        }

        return list;
    }
}
