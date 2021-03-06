package com.basis.sge.service.servico.dto;
import com.basis.sge.service.dominio.Evento;
import com.basis.sge.service.dominio.TipoSituacao;
import com.basis.sge.service.dominio.Usuario;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class InscricaoDTO implements Serializable {
    private Integer id;
    private Integer idUsuario;
    private Integer idEvento;
    private Integer idTipoSituacao;
    private List<InscricaoRespostaDTO> respostas = new ArrayList<>();

}
