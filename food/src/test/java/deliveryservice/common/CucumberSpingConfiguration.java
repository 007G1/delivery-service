package deliveryservice.common;


import deliveryservice.FoodApplication;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = { FoodApplication.class })
public class CucumberSpingConfiguration {
    
}
