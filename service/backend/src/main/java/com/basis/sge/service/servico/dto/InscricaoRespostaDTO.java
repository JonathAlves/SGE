package com.basis.sge.service.servico.dto;

import com.basis.sge.service.dominio.IdInscricaoResposta;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InscricaoRespostaDTO {

    private IdInscricaoResposta id;
    private Integer idEvento;
    private Integer idPergunta;
    private Integer idInscricao;
    private String resposta;
}
