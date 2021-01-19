package com.basis.sge.service.dominio;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

@Embeddable
@Getter
@Setter
public class IdInscricaoResposta {

    private Integer idInscricao;

    private Integer idEvento;

    private  Integer idPergunta;
}
