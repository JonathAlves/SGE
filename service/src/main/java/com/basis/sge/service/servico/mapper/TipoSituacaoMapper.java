package com.basis.sge.service.servico.mapper;

import com.basis.sge.service.dominio.Inscricao;
import com.basis.sge.service.dominio.TipoSituacao;
import com.basis.sge.service.servico.dto.InscricaoDTO;
import com.basis.sge.service.servico.dto.TipoSituacaoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses =   TipoSituacao.class)
public interface TipoSituacaoMapper extends EntityMapper<TipoSituacaoDTO, TipoSituacao>{

   /* TipoSituacao toEntity(TipoSituacaoDTO tipoSituacaoDTO);*/
}
