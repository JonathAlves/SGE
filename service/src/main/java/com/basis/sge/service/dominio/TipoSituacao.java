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
<<<<<<< HEAD
    @Column(name="id")
=======
    @Column(name="id_tipo_situacao")
>>>>>>> bb6c4eae029567c0af8fec4c205f9aee985f2fb4
    private Integer id;

    @Column(name="descricao")
    private String descricao;
}
