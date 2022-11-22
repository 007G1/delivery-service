package deliveryservice.infra;
import deliveryservice.domain.*;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import org.springframework.hateoas.EntityModel;

@Component
public class FoodHateoasProcessor implements RepresentationModelProcessor<EntityModel<Food>>  {

    @Override
    public EntityModel<Food> process(EntityModel<Food> model) {
        model.add(Link.of(model.getRequiredLink("self").getHref() + "/check").withRel("check"));

        
        return model;
    }
    
}
