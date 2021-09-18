package demo.codesgrammr.listener;

import demo.codesgrammr.event.ShipmentOrderCreatedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class ShipmentOrderCreatedEventListener implements ApplicationListener<ShipmentOrderCreatedEvent> {

    @Override
    public void onApplicationEvent(ShipmentOrderCreatedEvent event) {
        // We are only receiving specific event type, other event type would not come here
        System.out.println(getClass().getSimpleName() + " Received event: " + event);
    }
}
