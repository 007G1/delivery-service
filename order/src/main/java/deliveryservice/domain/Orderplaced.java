package deliveryservice.domain;

import deliveryservice.infra.AbstractEvent;
import lombok.Data;
import java.util.*;

@Data
public class Orderplaced extends AbstractEvent {

    private Long id;
    private String customerId;
    private Long foodId;
    private String status;
}
