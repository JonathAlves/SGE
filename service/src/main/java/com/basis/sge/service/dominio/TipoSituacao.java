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
    private Integer id;

    @Column(name="descricao")
    private String descricao;
}
