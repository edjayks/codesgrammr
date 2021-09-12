package demo.codesgrammr.app;

import demo.codesgrammr.dao.ShipmentOrderDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ShipmentOrderStaticFactoryApp {

    private ApplicationContext applicationContext;

    public static void main(String[] args) {
        ShipmentOrderStaticFactoryApp shipmentOrderStaticFactoryApp = new ShipmentOrderStaticFactoryApp();

        shipmentOrderStaticFactoryApp.instantiateSpringApp();
    }

    private void instantiateSpringApp() {
        applicationContext = new ClassPathXmlApplicationContext("shipment-order-static-factory-context.xml");

        assert applicationContext != null;

        ShipmentOrderDao shipmentOrderDao = applicationContext.getBean(ShipmentOrderDao.class);
        assert shipmentOrderDao != null;
        shipmentOrderDao.findShipmentOrder(14L);
    }
}
