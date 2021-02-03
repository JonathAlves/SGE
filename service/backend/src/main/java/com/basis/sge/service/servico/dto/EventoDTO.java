package com.basis.sge.service.servico.dto;

import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class EventoDTO implements Serializable {
    private Integer id;

    private String titulo;

    private LocalDateTime dataInicio;

    private LocalDateTime dataTermino;

    private String descricao;

    private Integer qtVagas;

    private Double valor;

    private String local;

    private Boolean tipoInscricao;

    private Integer idTipoEvento;

    private List<EventoPerguntaDTO> perguntas;
}
