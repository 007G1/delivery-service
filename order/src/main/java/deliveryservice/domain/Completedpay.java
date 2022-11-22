package deliveryservice.domain;

import deliveryservice.infra.AbstractEvent;
import lombok.Data;
import java.util.*;

@Data
public class Completedpay extends AbstractEvent {

    private Long id;
    private String status;
    private String customerId;
    private Long orderId;
}
