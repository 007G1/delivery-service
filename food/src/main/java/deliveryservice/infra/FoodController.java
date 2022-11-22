package deliveryservice.infra;
import deliveryservice.domain.*;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

@RestController
// @RequestMapping(value="/foods")
@Transactional
public class FoodController {
    @Autowired
    FoodRepository foodRepository;



    @RequestMapping(value = "foods/{id}/check",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8")
    public Food check(@PathVariable(value = "id") Long id, HttpServletRequest request, HttpServletResponse response) throws Exception {
            System.out.println("##### /food/check  called #####");
            Optional<Food> optionalFood = foodRepository.findById(id);
            
            optionalFood.orElseThrow(()-> new Exception("No Entity Found"));
            Food food = optionalFood.get();
            food.check();
            
            foodRepository.save(food);
            return food;
            
    }
    




}
