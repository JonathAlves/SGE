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
    @Id
<<<<<<< HEAD
=======
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_inscricao")
>>>>>>> bb6c4eae029567c0af8fec4c205f9aee985f2fb4
    @Column(name="id")
    private Integer id;

    @Column(name="id_evento")
    private Integer idEvento;

    @Column(name="id_usuario")
    private Integer idUsuario;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="id_tipo_situacao")
    private List<TipoSituacao> tipoSituacaoList;
}
