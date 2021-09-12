package demo.codesgrammr.adapter;

import demo.codesgrammr.bean.ShipmentOrder;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Imagine this implementing Adapter Design Pattern,
 * where we convert http request object into another object type to work with internal subsystems.
 */
@Component
public class ShipmentOrderAdapter {

    public ShipmentOrder convert(Map<String, String>request) {
        ShipmentOrder shipmentOrder = new ShipmentOrder();

        // conversion logics goes here...

        return shipmentOrder;
    }
}
