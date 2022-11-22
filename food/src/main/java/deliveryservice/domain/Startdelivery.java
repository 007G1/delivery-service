package deliveryservice.domain;

import deliveryservice.domain.*;
import deliveryservice.infra.AbstractEvent;
import lombok.*;
import java.util.*;
@Data
@ToString
public class Startdelivery extends AbstractEvent {

    private Long id;
    private String status;
    private String riderId;
    private Long orderId;
}


