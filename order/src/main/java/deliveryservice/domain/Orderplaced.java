package deliveryservice.domain;

import deliveryservice.domain.*;
import deliveryservice.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class Orderplaced extends AbstractEvent {

    private Long id;
    private String customerId;
    private Long storeId;

    public Orderplaced(Order aggregate){
        super(aggregate);
    }
    public Orderplaced(){
        super();
    }
}
