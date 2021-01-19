package com.basis.sge.service.dominio;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

@Embeddable
@Getter
@Setter
public class EventoPerguntaId {

    private Integer idEvento;

    private Integer IdPergunta;
}
