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

    @Id
<<<<<<< HEAD
    private Integer id;


    @Id
=======
>>>>>>> bb6c4eae029567c0af8fec4c205f9aee985f2fb4
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_inscricao")
    private Inscricao inscricao;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_evento")
    private Evento evento;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pergunta")
    private Pergunta pergunta;


    @Column (name = "resposta")
    private String resposta;



}