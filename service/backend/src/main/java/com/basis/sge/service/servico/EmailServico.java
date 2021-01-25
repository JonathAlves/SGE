package com.basis.sge.service.servico;
import com.basis.sge.service.configuracao.ApplicationProperties;
import com.basis.sge.service.dominio.Inscricao;
import com.basis.sge.service.dominio.Usuario;
import com.basis.sge.service.servico.dto.EmailDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;

@Service
@RequiredArgsConstructor
public class EmailServico {

    private static final String ERROR_TITLE = "error.title";

    private final JavaMailSender javaMailSender;
    private final ApplicationProperties properties;


    public void sendMail(EmailDTO emailDTO) {
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper message = new MimeMessageHelper(mimeMessage, false, "UTF-8");
            message.setTo(emailDTO.getDestinatario());
            message.setFrom(properties.getEnderecoRemetente(), properties.getNomeRemetente());
            message.setSubject(emailDTO.getAssunto());
            for (String s : emailDTO.getCopias()) {
                message.addCc(s);
            }
            message.setText(emailDTO.getCorpo(), true);
            javaMailSender.send(mimeMessage);
        } catch (MessagingException | UnsupportedEncodingException e) {
            throw new RuntimeException(ERROR_TITLE);
        }

        }
    public void  emailEnviarCadastro(Usuario usuario){
        EmailDTO emailDTO = new EmailDTO();
        emailDTO.setAssunto("Cadastro do usuario");
        emailDTO.setCorpo("Obrigado por se cadastrar na nossa plataforma! Sua chave:"  + usuario.getChave());
        emailDTO.setDestinatario(usuario.getEmail());
        sendMail(emailDTO);
    }

    public void  emailEnviarInscricao(Inscricao inscricao){
        EmailDTO emailDTO = new EmailDTO();
        emailDTO.setAssunto("Inscrição no evento");
        emailDTO.setCorpo("Obrigado por se inscrever no nosso evento!");
        emailDTO.setDestinatario(inscricao.getUsuario().getEmail());
        sendMail(emailDTO);
    }



}
        




