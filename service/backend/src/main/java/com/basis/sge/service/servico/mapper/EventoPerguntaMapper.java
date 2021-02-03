package com.basis.sge.service.servico.mapper;

import com.basis.sge.service.dominio.EventoPergunta;
import com.basis.sge.service.servico.dto.EventoPerguntaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {})
public interface EventoPerguntaMapper extends EntityMapper<EventoPerguntaDTO, EventoPergunta> {

    @Override
    @Mapping(source = "idPergunta",target = "pergunta.id")
    @Mapping(source = "idEvento",target = "evento.id")
    @Mapping(source = "idPergunta",target = "id.idPergunta")
    @Mapping(source = "idEvento",target = "id.idEvento")
    EventoPergunta toEntity(EventoPerguntaDTO eventoPerguntaDTO);

    @Override
    @Mapping(source = "pergunta.id",target = "idPergunta")
    @Mapping(source = "evento.id",target = "idEvento")
    EventoPerguntaDTO toDto(EventoPergunta eventoPergunta);
}
