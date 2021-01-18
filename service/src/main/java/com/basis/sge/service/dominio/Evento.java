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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;
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

    @NotNull
    @Column (name = "titulo", nullable = false)
    private String titulo;

    @NotNull
    @Column (name = "datahora_inicio", nullable = false)
    private LocalDateTime datahora_inicio;

    @NotNull
    @Column (name = "datahora_final", nullable = false)
    private LocalDateTime datahora_final;


    @Column (name = "descricao", nullable = false)
    private String descricao;

    //    @Column (name = "id_tipo_evento", nullable = false)
//    private Integer id_tipo_evento;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_evento", nullable = true, referencedColumnName = "id")
    private TipoEvento id_tipo_evento;

    @Column (name = "quantidade_vaga", nullable = true)
    private Integer quantidade_vaga;

    @Column (name = "valor", nullable = true)
    private Double valor;

    @Column (name = "local_evento", nullable = false)
    private String local_evento;

    @Column (name = "tipo_inscricao", nullable = false)
    private Boolean tipo_inscricao;


    @ManyToMany
    @JoinTable(
            name = "evento_pergunta",
            joinColumns = {@JoinColumn(name = "id_evento")},
            inverseJoinColumns = {@JoinColumn(name = "id_pergunta")}
    )
    private List<Pergunta> perguntas;

    public List<Pergunta> getPergunta() {
        return perguntas;
    }

}