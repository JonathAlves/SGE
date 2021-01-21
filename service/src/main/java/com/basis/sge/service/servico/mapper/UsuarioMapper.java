package com.basis.sge.service.servico.mapper;

import com.basis.sge.service.dominio.Inscricao;
import com.basis.sge.service.dominio.Usuario;
import com.basis.sge.service.servico.dto.InscricaoDTO;
import com.basis.sge.service.servico.dto.UsuarioDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = Usuario.class)

public interface UsuarioMapper extends EntityMapper<UsuarioDTO, Usuario>{


}
