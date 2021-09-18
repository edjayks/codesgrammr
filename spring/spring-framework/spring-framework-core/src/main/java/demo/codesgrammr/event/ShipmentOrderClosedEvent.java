package demo.codesgrammr.event;

import org.springframework.context.ApplicationEvent;

public class ShipmentOrderClosedEvent extends ApplicationEvent {

    private Long shipmentOrderId;

    public ShipmentOrderClosedEvent(Object source) {
        super(source);
    }
}
