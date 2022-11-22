package deliveryservice.domain;

import deliveryservice.domain.Startdelivery;
import deliveryservice.domain.Enddelivery;
import deliveryservice.DeliveryApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;

@Entity
@Table(name="Delivery_table")
@Data

public class Delivery  {

    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long id;
    
    
    
    
    
    private String riderId;
    
    
    
    
    
    private Long orderId;
    
    
    
    
    
    private String status;

    @PostPersist
    public void onPostPersist(){


        Startdelivery startdelivery = new Startdelivery(this);
        startdelivery.publishAfterCommit();



        Enddelivery enddelivery = new Enddelivery(this);
        enddelivery.publishAfterCommit();

    }

    public static DeliveryRepository repository(){
        DeliveryRepository deliveryRepository = DeliveryApplication.applicationContext.getBean(DeliveryRepository.class);
        return deliveryRepository;
    }






}
