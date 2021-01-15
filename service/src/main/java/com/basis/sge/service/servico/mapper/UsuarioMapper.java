package com.basis.sge.service.servico.mapper;

import com.basis.sge.service.dominio.Usuario;
import com.basis.sge.service.servico.dto.UsuarioDTO;
import com.bertoncelj.jdbi.entitymapper.EntityMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})

public interface UsuarioMapper extends EntityMapper<UsuarioDTO, Usuario>{

}
