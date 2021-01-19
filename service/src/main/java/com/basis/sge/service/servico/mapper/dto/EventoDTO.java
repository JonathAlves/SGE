package com.basis.sge.service.servico.mapper.dto;

import com.basis.sge.service.dominio.Pergunta;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class EventoDTO {
    private Integer id;

    private String titulo;

    private LocalDateTime datahoraInicio;

    private LocalDateTime datahoraFinal;

    private String descricao;

    private Integer quantidadeVaga;

    private Double valor;

    private String localEvento;

    private Boolean tipoInscricao;

    private Integer idTipoEvento;

//    private List<Pergunta> perguntas;
}
