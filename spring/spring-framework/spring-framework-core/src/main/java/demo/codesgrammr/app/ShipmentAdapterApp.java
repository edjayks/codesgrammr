package demo.codesgrammr.app;

import demo.codesgrammr.adapter.ShipmentOrderAdapter;
import demo.codesgrammr.bean.ShipmentOrder;
import demo.codesgrammr.config.ShipmentAdapterConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.HashMap;

public class ShipmentAdapterApp {

    private ApplicationContext applicationContext;

    public static void main(String[] args) {
        ShipmentAdapterApp shipmentAdapterApp = new ShipmentAdapterApp();

        shipmentAdapterApp.initiateSpringApp();
    }

    private void initiateSpringApp() {
        applicationContext = new AnnotationConfigApplicationContext(ShipmentAdapterConfig.class);

        assert applicationContext != null;

        ShipmentOrderAdapter shipmentOrderAdapter = applicationContext.getBean(ShipmentOrderAdapter.class);
        ShipmentOrder shipmentOrder = shipmentOrderAdapter.convert(new HashMap<>());

        assert shipmentOrder != null;
    }
}
