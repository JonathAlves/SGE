package com.basis.sge.service.servico.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class UsuarioDTO {

    private Integer id;
    private String cpf;
    private String nome;
    private LocalDate dataNascimento;
    private String telefone;
    private String email;




}
