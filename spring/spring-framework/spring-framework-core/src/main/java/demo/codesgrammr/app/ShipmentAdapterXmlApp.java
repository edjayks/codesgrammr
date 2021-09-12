package demo.codesgrammr.app;

import demo.codesgrammr.adapter.ShipmentOrderAdapter;
import demo.codesgrammr.bean.ShipmentOrder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;

public class ShipmentAdapterXmlApp {

    private ApplicationContext applicationContext;

    public static void main(String[] args) {
        ShipmentAdapterXmlApp shipmentAdapterXmlApp = new ShipmentAdapterXmlApp();

        shipmentAdapterXmlApp.initiateSpringApp();
    }

    private void initiateSpringApp() {
        applicationContext = new ClassPathXmlApplicationContext("shipment-adapter-context.xml");

        assert applicationContext != null;

        ShipmentOrderAdapter shipmentOrderAdapter = applicationContext.getBean(ShipmentOrderAdapter.class);
        ShipmentOrder shipmentOrder = shipmentOrderAdapter.convert(new HashMap<>());

        assert shipmentOrder != null;
    }
}
