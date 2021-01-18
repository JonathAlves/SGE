package com.basis.sge.service.servico.dto;
import com.basis.sge.service.dominio.Evento;
import com.basis.sge.service.dominio.TipoSituacao;
import com.basis.sge.service.dominio.Usuario;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InscricaoDTO{
    private Integer id;
    private Usuario idUsuario;
    private Evento idEvento;
    private TipoSituacao idTipoSituacao;
    private String pergunta;
}
