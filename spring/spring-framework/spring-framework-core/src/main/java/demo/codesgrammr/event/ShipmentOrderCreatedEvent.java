package demo.codesgrammr.event;

import org.springframework.context.ApplicationEvent;

public class ShipmentOrderCreatedEvent extends ApplicationEvent {

    private Long shipmentOrderId;

    public ShipmentOrderCreatedEvent(Object source) {
        super(source);
    }
}
