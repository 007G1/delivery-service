package deliveryservice.domain;

import deliveryservice.domain.*;
import deliveryservice.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class Startdelivery extends AbstractEvent {

    private Long id;
    private String status;
    private String riderId;
    private Long orderId;

    public Startdelivery(Delivery aggregate){
        super(aggregate);
    }
    public Startdelivery(){
        super();
    }
}
