package com.basis.sge.service.dominio;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

@Entity
@Table (name = "tipo_evento")
@Getter
@Setter
public class TipoEvento implements Serializable {

    @Id

    @Column (name = "id")
    private Integer id;

    @Column(name ="descricao")
    private String descricao;

    @OneToMany
    @JoinColumn(name = "id_tipo_evento")
    private List<Evento> evento;
}
