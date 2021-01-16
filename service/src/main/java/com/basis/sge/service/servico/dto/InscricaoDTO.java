package com.basis.sge.service.servico.dto;
import com.basis.sge.service.dominio.TipoSituacao;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InscricaoDTO{
    private Integer id;
    private TipoSituacao tipoSituacao;
    private String pergunta;
}
