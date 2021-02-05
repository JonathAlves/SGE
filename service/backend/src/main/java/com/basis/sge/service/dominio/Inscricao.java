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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_inscricao")
    @SequenceGenerator(name = "sq_inscricao", allocationSize = 1, sequenceName = "sq_inscricao")
    @Column(name="id")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_evento")
    private Evento evento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_usuario")
    private Usuario usuario;

    @ManyToOne( fetch = FetchType.LAZY)
    @JoinColumn(name="id_tipo_situacao")
    private TipoSituacao tipoSituacao;

    @OneToMany(fetch = FetchType.LAZY, orphanRemoval = false, mappedBy = "inscricao")
    private List<InscricaoResposta> respostas;
}
