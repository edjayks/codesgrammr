package demo.codesgrammr.publisher;

import demo.codesgrammr.event.ShipmentOrderClosedEvent;
import demo.codesgrammr.event.ShipmentOrderCreatedEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

@Component
public class ShipmentOrderEventPublisher implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public void sendShipmentOrderCreatedEvent(Long orderId) {
        applicationEventPublisher.publishEvent(new ShipmentOrderCreatedEvent(orderId));
    }

    public void sendShipmentOrderClosedEvent(Long orderId) {
        applicationEventPublisher.publishEvent(new ShipmentOrderClosedEvent(orderId));
    }
}
