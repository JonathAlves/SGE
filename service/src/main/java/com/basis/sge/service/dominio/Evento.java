package com.basis.sge.service.dominio;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "evento")
@Getter
@Setter

public class Evento implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_evento")
    @SequenceGenerator(name = "sq_evento", allocationSize = 1, sequenceName = "sq_evento")
    @Column(name = "id")
    private Integer id;
    @Column (name = "titulo")
    private String titulo;

    @Column (name = "datahora_inicio")
    private Timestamp datahoraInicio;

    @Column (name = "datahora_final")
    private Timestamp datahoraFinal;

    @Column (name = "descricao")
    private String descricao;

    @Column (name = "quantidade_vaga")
    private Integer quantidadeVaga;

    @Column (name = "valor")
    private Double valor;

    @Column (name = "local_evento")
    private String localEvento;

    @Column (name = "tipo_inscricao")
    private Boolean tipoInscricao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_evento")
    private TipoEvento tipoEvento;

    @OneToMany(fetch = FetchType.LAZY, orphanRemoval = true, mappedBy = "evento")
    private List<EventoPergunta> perguntas;


}