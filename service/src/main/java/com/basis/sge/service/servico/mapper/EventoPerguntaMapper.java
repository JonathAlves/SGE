package com.basis.sge.service.servico.mapper;

import com.basis.sge.service.dominio.EventoPergunta;
import com.basis.sge.service.servico.dto.EventoPerguntaDTO;
import org.mapstruct.Mapper;

@Mapper
public interface EventoPerguntaMapper extends EntityMapper<EventoPerguntaDTO, EventoPergunta> {
}
