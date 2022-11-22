package deliveryservice.infra;

import javax.naming.NameParser;

import javax.naming.NameParser;
import javax.transaction.Transactional;

import deliveryservice.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import deliveryservice.domain.*;


@Service
@Transactional
public class PolicyHandler{
    @Autowired PayRepository payRepository;
    
    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='Orderplaced'")
    public void wheneverOrderplaced_Pay(@Payload Orderplaced orderplaced){

        Orderplaced event = orderplaced;
        System.out.println("\n\n##### listener Pay : " + orderplaced + "\n\n");


        

        // Sample Logic //
        Pay.pay(event);
        

        

    }

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='Ordercanceled'")
    public void wheneverOrdercanceled_Refund(@Payload Ordercanceled ordercanceled){

        Ordercanceled event = ordercanceled;
        System.out.println("\n\n##### listener Refund : " + ordercanceled + "\n\n");


        

        // Sample Logic //
        Pay.refund(event);
        

        

    }

}


