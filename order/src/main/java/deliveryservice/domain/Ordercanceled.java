package deliveryservice.domain;

import deliveryservice.infra.AbstractEvent;
import lombok.Data;
import java.util.*;

@Data
public class Ordercanceled extends AbstractEvent {

    private Long id;
    private String customerId;
    private Long storeId;
}
