package com.basis.sge.service.servico.dto;

import com.basis.sge.service.dominio.Evento;
import com.basis.sge.service.dominio.Inscricao;
import com.basis.sge.service.dominio.Pergunta;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InscricaoRespostaDTO {
    private Evento evento;
    private Pergunta pergunta;
    private Inscricao inscricao;
    private String resposta;
}
