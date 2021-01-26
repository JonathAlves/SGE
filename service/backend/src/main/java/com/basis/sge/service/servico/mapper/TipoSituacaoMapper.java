package com.basis.sge.service.servico.mapper;

import com.basis.sge.service.dominio.Inscricao;
import com.basis.sge.service.dominio.TipoSituacao;
import com.basis.sge.service.servico.dto.InscricaoDTO;
import com.basis.sge.service.servico.dto.TipoSituacaoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {})
public interface TipoSituacaoMapper extends EntityMapper<TipoSituacaoDTO, TipoSituacao>{

    @Mapping(source = "id", target = "id")
    TipoSituacao toEntity(TipoSituacaoDTO tipoSituacaoDTO);

    @Mapping(source = "id", target = "id")
    TipoSituacaoDTO toDto(TipoSituacao tipoSituacao);



}
