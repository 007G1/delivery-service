package deliveryservice.domain;

import deliveryservice.domain.Orderplaced;
import deliveryservice.domain.Ordercanceled;
import deliveryservice.domain.Orderchecked;
import deliveryservice.OrderApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;

@Entity
@Table(name="Order_table")
@Data

public class Order  {

    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long id;
    
    
    
    
    
    private String customerId;
    
    
    
    
    
    private String foodId;
    
    
    
    
    
    private String status;

    @PostPersist
    public void onPostPersist(){


        Orderplaced orderplaced = new Orderplaced(this);
        orderplaced.publishAfterCommit();



        Ordercanceled ordercanceled = new Ordercanceled(this);
        ordercanceled.publishAfterCommit();



        Orderchecked orderchecked = new Orderchecked(this);
        orderchecked.publishAfterCommit();

    }

    public static OrderRepository repository(){
        OrderRepository orderRepository = OrderApplication.applicationContext.getBean(OrderRepository.class);
        return orderRepository;
    }






}
