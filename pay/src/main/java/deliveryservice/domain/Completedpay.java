package deliveryservice.domain;

import deliveryservice.domain.*;
import deliveryservice.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class Completedpay extends AbstractEvent {

    private Long id;
    private String status;
    private String customerId;
    private Long orderId;

    public Completedpay(Pay aggregate){
        super(aggregate);
    }
    public Completedpay(){
        super();
    }
}
