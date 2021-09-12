package demo.codesgrammr.app;

import demo.codesgrammr.service.ShipmentOrderService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ShipmentOrderApp {

    private ApplicationContext applicationContext;

    public static void main(String[] args) {
        ShipmentOrderApp shipmentOrderApp = new ShipmentOrderApp();

        shipmentOrderApp.initiateSpringApp();
    }

    private void initiateSpringApp() {
        applicationContext =
                new AnnotationConfigApplicationContext("demo.codesgrammr.config");

        assert applicationContext != null;

        ShipmentOrderService shipmentOrderService = applicationContext.getBean(ShipmentOrderService.class);
        shipmentOrderService.findShipmentOrder(12L);
    }
}
