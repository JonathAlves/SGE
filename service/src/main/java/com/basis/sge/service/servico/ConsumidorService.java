package com.basis.sge.service.servico;

import com.basis.sge.service.servico.dto.EmailDTO;
import com.basis.sge.service.servico.rabbit.ConsumidorTarget;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

@Service
@Slf4j
@ResponseStatus
@EnableBinding(ConsumidorTarget.class)
public class ConsumidorService {

    private final EmailServico emailServico;

    public ConsumidorService(EmailServico emailServico) {
        this.emailServico = emailServico;
    }

    @StreamListener(target = ConsumidorTarget.BINDING_MAILER)
    public void senfMail(@Payload EmailDTO emailDTO){
        log.info("Evento recebido {}", emailDTO);
        emailServico.sendMail(emailDTO);
    }
}
