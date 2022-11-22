package deliveryservice.domain;

import deliveryservice.domain.*;
import deliveryservice.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class Startcook extends AbstractEvent {

    private Long id;
    private Long orderId;
    private String customerId;
    private String status;

    public Startcook(Food aggregate){
        super(aggregate);
    }
    public Startcook(){
        super();
    }
}
