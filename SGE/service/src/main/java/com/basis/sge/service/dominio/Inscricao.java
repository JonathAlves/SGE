package com.basis.sge.service.dominio;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "inscricao")
@Getter
@Setter
public class Inscricao implements Serializable{
    @Id
    @Column(name="id")
    private long id;

    @Column(name="id_evento")
    private Integer idEvento;

    @Column(name="id_usuario")
    private Integer idUsuario;

    @Column(name="id_tipo_situacao")
    @OneToMany(mappedBy="idTipoSituacao")
    @JoinColumn()
    private List<TipoSituacao> TiposSituacao;

}
