package com.basis.sge.service.dominio;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.io.Serializable;


@Getter
@Setter
@Embeddable
public class EventoPerguntaId implements Serializable {

    private Integer idPergunta;
    private Integer idEvento;
}
