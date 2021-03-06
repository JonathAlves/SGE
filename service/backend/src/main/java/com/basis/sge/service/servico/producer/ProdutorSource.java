package com.basis.sge.service.servico.producer;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface ProdutorSource {
    String BINDING_MAILER = "mailer";

    @Output(ProdutorSource.BINDING_MAILER)
    MessageChannel enviarEmail();
}
