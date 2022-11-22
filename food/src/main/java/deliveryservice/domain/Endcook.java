package deliveryservice.domain;

import deliveryservice.domain.*;
import deliveryservice.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class Endcook extends AbstractEvent {

    private Long id;
    private String cutomerId;
    private Long orderId;
    private String status;

    public Endcook(Food aggregate){
        super(aggregate);
    }
    public Endcook(){
        super();
    }
}
