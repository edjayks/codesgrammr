package demo.codesgrammr.listener;

import demo.codesgrammr.event.ShipmentOrderClosedEvent;
import demo.codesgrammr.event.ShipmentOrderCreatedEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class ShipmentOrderPostProcessor {

    @EventListener
    public void onShipmentOrderCreated(ShipmentOrderCreatedEvent shipmentOrderCreatedEvent) {
        System.out.println(getClass().getSimpleName() + " Received event: " + shipmentOrderCreatedEvent);
    }

    @EventListener
    public void onShipmentOrderClosed(ShipmentOrderClosedEvent shipmentOrderClosedEvent) {
        System.out.println(getClass().getSimpleName() + " Received event: " + shipmentOrderClosedEvent);
    }

    @EventListener
    public void allEventPostProcessor(ApplicationEvent applicationEvent) {
        System.out.println(getClass().getSimpleName() + " Received event: " + applicationEvent);
    }
}
