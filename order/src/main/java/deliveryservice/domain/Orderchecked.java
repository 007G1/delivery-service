package deliveryservice.domain;

import deliveryservice.domain.*;
import deliveryservice.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class Orderchecked extends AbstractEvent {

    private Long id;
    private String state;
    private String customerId;
    private Long orderId;

    public Orderchecked(Order aggregate){
        super(aggregate);
    }
    public Orderchecked(){
        super();
    }
}
