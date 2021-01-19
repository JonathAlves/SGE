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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "evento")
@Getter
@Setter

public class Evento implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_evento")
    @SequenceGenerator(name = "sq_evento", allocationSize = 1)
    private Integer id;

    @NotNull
    @Column (name = "titulo")
    private String titulo;

    @NotNull
    @Column (name = "datahora_inicio")
    private LocalDateTime datahoraInicio;

    @NotNull
    @Column (name = "datahora_final")
    private LocalDateTime datahoraFinal;


    @Column (name = "descricao")
    private String descricao;

    @Column (name = "quantidade_vaga")
    private Integer quantidadeVaga;

    @Column (name = "valor")
    private Double valor;

    @Column (name = "local_evento")
    private String localEvento;

    @NotNull
    @Column (name = "tipo_inscricao")
    private Boolean tipoInscricao;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_tipo_evento", referencedColumnName = "id")
    private TipoEvento tipoEvento;

    @OneToMany(fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Pergunta> perguntas;


}