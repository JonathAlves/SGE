package com.basis.sge.service.dominio;

import lombok.Getter;
import lombok.Setter;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;


@Entity
@Table(name = "pergunta")
@Getter
@Setter
public class Pergunta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_pergunta")
    @SequenceGenerator(name = "sq_pergunta", allocationSize = 1, sequenceName = "sq_pergunta")
    @Column(name = "id")
    private Integer id;

    @Column(name = "titulo")
    private String titulo;

    @ManyToMany(mappedBy = "pergunta")
    private List<Evento> eventos;

    @OneToMany
    @JoinColumn(name = "id_pergunta")
    private List<InscricaoResposta> inscricaoRespostas;

}