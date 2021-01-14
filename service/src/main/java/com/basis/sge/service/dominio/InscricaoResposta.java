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
import javax.persistence.Table;
import java.io.Serializable;


@Entity
@Table (name = "inscricao_resposta")
@Getter
@Setter
public class InscricaoResposta implements Serializable {


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_inscricao")
    private Inscricao inscricao;
    @Id
    @Column (name = "id_inscricao")
    private Integer idinscricao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_evento")
    private Evento evento;
    @Id
    @Column (name = "id_evento")
    private Integer idEvento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pergunta")
    private Pergunta pergunta;
    @Id
    @Column(name = "id_pergunta")
    private Integer idPergunta;



    @Column (name = "resposta")
    private String resposta;



}