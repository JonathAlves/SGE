package com.basis.sge.service.servico.mapper;

import com.basis.sge.service.dominio.Inscricao;
import com.basis.sge.service.servico.dto.InscricaoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = Inscricao.class)
public interface InscricaoMapper extends EntityMapper<InscricaoDTO, Inscricao>{


    Inscricao toEntity(InscricaoDTO inscricaoDTO);


}
