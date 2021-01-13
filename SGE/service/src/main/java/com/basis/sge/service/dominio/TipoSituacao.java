package com.basis.sge.service.dominio;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="tipo_situacao")
@Getter
@Setter

public class TipoSituacao implements Serializable{
    @Id
    @Column(name="id")
    @ManyToOne
    private Inscricao idTipoSituacao;

    @Column(name="descricao")
    private String descricao;

}
