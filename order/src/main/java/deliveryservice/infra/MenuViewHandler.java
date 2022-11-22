package deliveryservice.infra;

import deliveryservice.domain.*;
import deliveryservice.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class MenuViewHandler {


    @Autowired
    private MenuRepository menuRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrderplaced_then_CREATE_1 (@Payload Orderplaced orderplaced) {
        try {

            if (!orderplaced.validate()) return;

            // view 객체 생성
            Menu menu = new Menu();
            // view 객체에 이벤트의 Value 를 set 함
            menu.setCustomerId(orderplaced.getCustomerId());
            menu.setId(orderplaced.getId());
            menu.setFoodId(orderplaced.getFoodId());
            // view 레파지 토리에 save
            menuRepository.save(menu);

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whenCompletedpay_then_UPDATE_1(@Payload Completedpay completedpay) {
        try {
            if (!completedpay.validate()) return;
                // view 객체 조회

                List<Menu> menuList = menuRepository.findByStatus(completedpay.getStatus());
                for(Menu menu : menuList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    menu.setStatus(completedpay.getStatus());
                // view 레파지 토리에 save
                menuRepository.save(menu);
                }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrdercanceled_then_DELETE_1(@Payload Ordercanceled ordercanceled) {
        try {
            if (!ordercanceled.validate()) return;
            // view 레파지 토리에 삭제 쿼리
            menuRepository.deleteById(ordercanceled.getId());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

