package com.basis.sge.service.servico.mapper.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Getter
@Setter
public class EventoDTO {
    private Integer id;
    private String titulo;
    private LocalDateTime datahora_inicio;
    private LocalDateTime datahora_final;
    private String descricao;
    private Integer quantidade_vaga;
    private Double valor;
    private String local_evento;
    private Boolean tipo_inscricao;
}
