package kiosk.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import kiosk.config.kafka.KafkaProcessor;
import kiosk.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

//<<< Clean Arch / Inbound Adaptor
@Service
@Transactional
public class PolicyHandler {

    @Autowired
    KitchenRepository kitchenRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='OrderOccured'"
    )
    public void wheneverOrderOccured_OrderOccur(
        @Payload OrderOccured orderOccured
    ) {
        OrderOccured event = orderOccured;
        System.out.println(
            "\n\n##### listener OrderOccur : " + orderOccured + "\n\n"
        );

        // Sample Logic //
        Kitchen.orderOccur(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
