package com.basis.sge.service.dominio;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
@Entity
@Table (name = "usuario")
@Getter
@Setter
public class Usuario implements Serializable {

    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "sq_usuario")
    @SequenceGenerator(name = "sq_usuario", allocationSize = 1, sequenceName = "sq_usuario")
    @Column(name = "id")
    private Integer id;

    @Column (name = "nome")
    private String nome;

    @Column (name = "cpf")
    private String cpf;

    @Column (name ="email")
    private String email;

    @Column (name = "telefone")
    private String telefone;

    @Column (name = "data_nascimento")
    private Date data_nascimento;

    @Column (name = "chave")
    private String chave;
}
