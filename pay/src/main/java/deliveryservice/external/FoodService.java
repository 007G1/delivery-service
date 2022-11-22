package deliveryservice.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

@FeignClient(name = "food", url = "${api.url.food}")
public interface FoodService {
    @RequestMapping(method= RequestMethod.PUT, path="/foods/{id}/check")
    public void check(@PathVariable("id") Long id);
}

