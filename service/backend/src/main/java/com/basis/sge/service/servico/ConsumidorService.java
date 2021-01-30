package com.basis.sge.service.servico;
import com.basis.sge.service.servico.EmailServico;
import com.basis.sge.service.servico.dto.EmailDTO;
import com.basis.sge.service.servico.rabbit.ConsumidorTarget;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
@EnableBinding(ConsumidorTarget.class)
public class ConsumidorService {

    private final EmailServico emailServico;

    @StreamListener(target = ConsumidorTarget.BINDING_MAILER)
    public void sendMail(@Payload EmailDTO emailDTO) {
        log.info("Evento recebido {}", emailDTO);
        emailServico.sendMail(emailDTO);
    }
}
