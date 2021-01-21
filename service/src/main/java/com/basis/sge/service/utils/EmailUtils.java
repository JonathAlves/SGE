//package com.basis.sge.service.utils;
//
//import com.basis.sge.service.dominio.Usuario;
//import com.basis.sge.service.servico.EmailServico;
//import com.basis.sge.service.servico.dto.EmailDTO;
//import com.basis.sge.service.servico.dto.UsuarioDTO;
//import lombok.Data;
//
//@Data
//public class EmailUtils {
//    private final  Usuario usuario;
//    private final EmailServico emailServico;
//
//
//    public void emailCadastro(EmailDTO emailDTO){
//        emailDTO.setAssunto("Cadastro do usuario");
//        emailDTO.setCorpo("Obrigado por se inscrever no nosso evento! Sua chave:" + usuario.getChave());
//        emailDTO.setDestinatario(usuario.getEmail());
//        emailDTO.setCopias(emailDTO.getCopias());
//        emailServico.sendMail(emailDTO);
//
//
//
//    }
//
//
//}
