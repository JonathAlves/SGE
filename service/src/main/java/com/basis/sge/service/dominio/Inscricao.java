package com.basis.sge.service.dominio;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@Table(name = "inscricao")
@Getter
@Setter
public class Inscricao implements Serializable{
    @Column(name="id")
    private Integer id;

    @Column(name="id_evento")
    private Integer idEvento;

    @Column(name="id_usuario")
    private Integer idUsuario;

    @OneToMany(cascade=CascadeType.ALL, mappedBy= "tipo_situacao" )
    @JoinColumn(name="id_tipo_situacao")
    private List<TipoSituacao> tipoSituacaoList;
}
