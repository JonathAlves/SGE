package com.basis.sge.service.servico.mapper;

import com.basis.sge.service.dominio.Inscricao;
import com.basis.sge.service.dominio.Usuario;
import com.basis.sge.service.servico.dto.InscricaoDTO;
import com.basis.sge.service.servico.dto.UsuarioDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring", uses = {})
public interface InscricaoMapper extends EntityMapper<InscricaoDTO, Inscricao>{

    @Override
    @Mapping(source = "idUsuario", target = "usuario.id")
    @Mapping(source = "idEvento", target = "evento.id")
    @Mapping(source = "idTipoSituacao", target = "tipoSituacao.id")
    Inscricao toEntity(InscricaoDTO inscricaoDTO);

    @Override
    @Mapping(source = "usuario.id", target = "idUsuario")
    @Mapping(source = "evento.id", target = "idEvento")
    @Mapping(source = "tipoSituacao.id", target = "idTipoSituacao")
    InscricaoDTO toDto(Inscricao inscricao);


}
