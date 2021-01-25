package com.basis.sge.service.servico.dto;

import com.basis.sge.service.dominio.Evento;
import com.basis.sge.service.dominio.EventoPerguntaId;
import com.basis.sge.service.dominio.Pergunta;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class EventoPerguntaDTO {

    private EventoPerguntaId id;
    private Evento evento;
    private Pergunta pergunta;
}
