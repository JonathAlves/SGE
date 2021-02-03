package com.basis.sge.service.servico.dto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
public class UsuarioDTO{

    private Integer id;
    @CPF
    private String cpf;
    private String nome;
    private LocalDate dataNascimento;
    private String telefone;
    @Email
    private String email;
    private String chave;
    private Boolean admin;




}
