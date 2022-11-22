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
    @Autowired FoodRepository foodRepository;
    
    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='Startcook'")
    public void wheneverStartcook_State(@Payload Startcook startcook){

        Startcook event = startcook;
        System.out.println("\n\n##### listener State : " + startcook + "\n\n");


        

        // Sample Logic //

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='Endcook'")
    public void wheneverEndcook_State(@Payload Endcook endcook){

        Endcook event = endcook;
        System.out.println("\n\n##### listener State : " + endcook + "\n\n");


        

        // Sample Logic //

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='Refundpay'")
    public void wheneverRefundpay_State(@Payload Refundpay refundpay){

        Refundpay event = refundpay;
        System.out.println("\n\n##### listener State : " + refundpay + "\n\n");


        

        // Sample Logic //

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='Orderchecked'")
    public void wheneverOrderchecked_State(@Payload Orderchecked orderchecked){

        Orderchecked event = orderchecked;
        System.out.println("\n\n##### listener State : " + orderchecked + "\n\n");


        

        // Sample Logic //

        

    }

}


