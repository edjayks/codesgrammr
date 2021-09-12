package demo.codesgrammr.app;

import demo.codesgrammr.dao.ShipmentOrderDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ShipmentOrderFactoryApp {

    private ApplicationContext applicationContext;

    public static void main(String[] args) {
        ShipmentOrderFactoryApp shipmentOrderFactoryApp = new ShipmentOrderFactoryApp();

        shipmentOrderFactoryApp.instantiateSpringApp();
    }

    private void instantiateSpringApp() {
        applicationContext = new ClassPathXmlApplicationContext("shipment-order-instance-factory-context.xml");

        assert applicationContext != null;

        ShipmentOrderDao shipmentOrderDao = applicationContext.getBean(ShipmentOrderDao.class);
        assert shipmentOrderDao != null;
        shipmentOrderDao.findShipmentOrder(15L);
    }
}
