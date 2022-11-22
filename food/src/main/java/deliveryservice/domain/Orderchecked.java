package deliveryservice.domain;

import deliveryservice.domain.*;
import deliveryservice.infra.AbstractEvent;
import lombok.*;
import java.util.*;
@Data
@ToString
public class Orderchecked extends AbstractEvent {

    private Long id;
    private String state;
    private String customerId;
    private Long orderId;
}


