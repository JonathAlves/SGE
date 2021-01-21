package com.basis.sge.service.utils;

import com.basis.sge.service.dominio.Inscricao;
import com.basis.sge.service.dominio.Usuario;
import com.basis.sge.service.servico.EmailServico;
import com.basis.sge.service.servico.dto.EmailDTO;
import com.basis.sge.service.servico.dto.UsuarioDTO;
import lombok.Data;

import javax.validation.constraints.Email;
/*
@Data
public class EmailUtils {
    private final  Usuario usuario;
    private final Inscricao inscricao;
    private final EmailServico emailServico;

    public void emailInscricao(EmailDTO emailDTO){
        emailDTO.setAssunto("Inscrição no evento");
        emailDTO.setCorpo("Obrigado por se inscrever no evento.");
        emailDTO.setDestinatario(inscricao.getUsuario().getEmail());
        emailServico.sendMail(emailDTO);
    }


}
*/