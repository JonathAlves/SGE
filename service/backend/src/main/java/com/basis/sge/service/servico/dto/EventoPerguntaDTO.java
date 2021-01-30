package com.basis.sge.service.servico.dto;

import com.basis.sge.service.dominio.EventoPerguntaId;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class EventoPerguntaDTO {

    private EventoPerguntaId id;
    private Integer idEvento;
    private Integer idPergunta;
}
