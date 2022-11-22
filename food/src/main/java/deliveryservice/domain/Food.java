package deliveryservice.domain;

import deliveryservice.domain.Startcook;
import deliveryservice.domain.Endcook;
import deliveryservice.FoodApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;

@Entity
@Table(name="Food_table")
@Data

public class Food  {

    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long id;
    
    
    
    
    
    private String status;
    
    
    
    
    
    private String foodname;
    
    
    
    
    
    private Integer cost;
    
    
    
    
    
    private Long orderId;

    @PostPersist
    public void onPostPersist(){


        Startcook startcook = new Startcook(this);
        startcook.publishAfterCommit();



        Endcook endcook = new Endcook(this);
        endcook.publishAfterCommit();

    }

    public static FoodRepository repository(){
        FoodRepository foodRepository = FoodApplication.applicationContext.getBean(FoodRepository.class);
        return foodRepository;
    }



    public void check(){
    }



}
