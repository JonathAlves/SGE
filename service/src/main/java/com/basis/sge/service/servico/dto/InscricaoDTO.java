package com.basis.sge.service.servico.dto;
import com.basis.sge.service.dominio.TipoSituacao;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class InscricaoDTO implements Serializable {
    private Integer id;
    private Integer idtipoSituacao;
    private Integer idUsuario;

}
