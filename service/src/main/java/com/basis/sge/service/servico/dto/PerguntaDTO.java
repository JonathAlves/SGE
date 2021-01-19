package com.basis.sge.service.servico.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PerguntaDTO {
    private Integer id;
    private String titulo;
    private Boolean obrigatoriedade;
}
