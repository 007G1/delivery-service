package deliveryservice.domain;

import deliveryservice.domain.*;
import deliveryservice.infra.AbstractEvent;
import lombok.*;
import java.util.*;
@Data
@ToString
public class Ordercanceled extends AbstractEvent {

    private Long id;
    private String customerId;
    private Long storeId;
}


