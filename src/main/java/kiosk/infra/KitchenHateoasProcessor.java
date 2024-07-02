package kiosk.infra;

import kiosk.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class KitchenHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Kitchen>> {

    @Override
    public EntityModel<Kitchen> process(EntityModel<Kitchen> model) {
        return model;
    }
}
