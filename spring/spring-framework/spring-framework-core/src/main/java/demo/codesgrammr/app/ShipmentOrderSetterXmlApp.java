package demo.codesgrammr.app;

import demo.codesgrammr.setter.ShipmentOrderSetterImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ShipmentOrderSetterXmlApp {

    private ApplicationContext applicationContext;

    public static void main(String[] args) {
        ShipmentOrderSetterXmlApp shipmentOrderSetterXmlApp = new ShipmentOrderSetterXmlApp();

        shipmentOrderSetterXmlApp.initiateSpringApp();
    }

    private void initiateSpringApp() {
        applicationContext = new ClassPathXmlApplicationContext("shipment-order-setter-context.xml");

        assert applicationContext != null;

        ShipmentOrderSetterImpl shipmentOrderSetter = applicationContext.getBean(ShipmentOrderSetterImpl.class);
        shipmentOrderSetter.updateShipmentOrder(16L);

        assert shipmentOrderSetter != null;

    }

}
