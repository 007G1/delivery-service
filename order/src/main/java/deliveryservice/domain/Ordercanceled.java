package deliveryservice.domain;

import deliveryservice.domain.*;
import deliveryservice.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class Ordercanceled extends AbstractEvent {

    private Long id;
    private String customerId;
    private Long storeId;

    public Ordercanceled(Order aggregate){
        super(aggregate);
    }
    public Ordercanceled(){
        super();
    }
}
