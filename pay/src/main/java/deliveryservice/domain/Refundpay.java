package deliveryservice.domain;

import deliveryservice.domain.*;
import deliveryservice.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class Refundpay extends AbstractEvent {

    private Long id;
    private String customerId;
    private Long orderId;

    public Refundpay(Pay aggregate){
        super(aggregate);
    }
    public Refundpay(){
        super();
    }
}
