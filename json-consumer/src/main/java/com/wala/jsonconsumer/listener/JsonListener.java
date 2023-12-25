package com.wala.jsonconsumer.listener;

import com.wala.jsonconsumer.model.Payment;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import static java.lang.Thread.sleep;

@Log4j2
@Component
public class JsonListener {

    @SneakyThrows
    @KafkaListener(topics = "payment-topic", groupId = "pdf-group", containerFactory =  "jsonContainerFactory")
    public void pdfGenerator(@Payload Payment payment){
        log.info("Gerando PDF do produto de id {} ...", payment.getId());
        sleep(3000);
    }

    @SneakyThrows
    @KafkaListener(topics = "payment-topic", groupId = "valid-group", containerFactory =  "jsonContainerFactory")
    public void antiFraud(@Payload Payment payment){
        log.info("Pagamento recebido {} ...", payment.toString());
        sleep(2000);
        log.info("Validando fraude...");
        sleep(2000);

        log.info("Compra aprovada");
        sleep(2000);
    }

}