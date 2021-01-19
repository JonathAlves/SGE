package com.basis.sge.service.servico.dto;
import com.basis.sge.service.dominio.Evento;
import com.basis.sge.service.dominio.TipoSituacao;
import com.basis.sge.service.dominio.Usuario;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class InscricaoDTO implements Serializable {
    private Integer id;
    private Usuario idUsuario;
    private Evento idEvento;
    private TipoSituacao idTipoSituacao;
    private String pergunta;

}
