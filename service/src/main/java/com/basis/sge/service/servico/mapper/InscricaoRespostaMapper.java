package com.basis.sge.service.servico.mapper;

import com.basis.sge.service.dominio.InscricaoResposta;
import com.basis.sge.service.servico.dto.InscricaoRespostaDTO;
import org.mapstruct.Mapper;
import org.springframework.web.bind.annotation.Mapping;

@Mapper(componentModel = "spring", uses = {})
public interface InscricaoRespostaMapper extends EntityMapper<InscricaoRespostaDTO, InscricaoResposta> {

    //@Override
    //@Mapping(source = "idInscricao", target = "inscricao.id")
    //InscricaoResposta toEntity(InscricaoRespostaDTO inscricaoRespostaDTO);

}
