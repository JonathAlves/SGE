package com.basis.sge.service.servico.mapper;

import com.basis.sge.service.dominio.Inscricao;
import com.basis.sge.service.servico.dto.InscricaoDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface InscricaoMapper extends EntityMapper<InscricaoDTO, Inscricao>{
}
