package demo.codesgrammr.app;

import demo.codesgrammr.adapter.ShipmentOrderAdapter;
import demo.codesgrammr.bean.ShipmentOrder;
import demo.codesgrammr.service.ShipmentOrderService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;

public class ShipmentOrderXmlApp {

    private ApplicationContext applicationContext;

    public static void main(String[] args) {
        ShipmentOrderXmlApp shipmentOrderXmlApp = new ShipmentOrderXmlApp();

        shipmentOrderXmlApp.initiateSpringApp();
    }

    private void initiateSpringApp() {
        applicationContext = new ClassPathXmlApplicationContext("shipment-order-context.xml");

        assert applicationContext != null;

        ShipmentOrderAdapter shipmentOrderAdapter = applicationContext.getBean(ShipmentOrderAdapter.class);
        ShipmentOrder shipmentOrder = shipmentOrderAdapter.convert(new HashMap<>());

        assert shipmentOrder != null;

        ShipmentOrderService shipmentOrderService = applicationContext.getBean(ShipmentOrderService.class);
        shipmentOrderService.findShipmentOrder(13L);
    }
}
