package deliveryservice.external;

import lombok.Data;
import java.util.Date;
@Data
public class Food {

    private Long id;
    private String status;
    private String foodname;
    private Integer cost;
    private Long orderId;
}


