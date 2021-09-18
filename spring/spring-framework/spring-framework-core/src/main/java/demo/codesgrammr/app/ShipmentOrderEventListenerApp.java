package demo.codesgrammr.app;

import demo.codesgrammr.publisher.ShipmentOrderEventPublisher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ShipmentOrderEventListenerApp {

    private ApplicationContext applicationContext;

    public static void main(String[] args) {
        ShipmentOrderEventListenerApp shipmentOrderEventListenerApp = new ShipmentOrderEventListenerApp();
        shipmentOrderEventListenerApp.initializeApp();
    }

    private void initializeApp() {
        applicationContext = new AnnotationConfigApplicationContext("demo.codesgrammr.event",
                "demo.codesgrammr.listener", "demo.codesgrammr.publisher");
        assert applicationContext != null;

        ShipmentOrderEventPublisher shipmentOrderEventPublisher = applicationContext.getBean(ShipmentOrderEventPublisher.class);
        assert shipmentOrderEventPublisher != null;

        shipmentOrderEventPublisher.sendShipmentOrderCreatedEvent(1L);
        shipmentOrderEventPublisher.sendShipmentOrderClosedEvent(1L);
    }
}
