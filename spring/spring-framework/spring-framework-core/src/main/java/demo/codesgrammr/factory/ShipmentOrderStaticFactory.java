package demo.codesgrammr.factory;

import demo.codesgrammr.dao.ShipmentOrderDao;

public class ShipmentOrderStaticFactory {

    private static ShipmentOrderDao shipmentOrderDao = new ShipmentOrderDao();

    public static ShipmentOrderDao createShipmentOrderDao() {
        return shipmentOrderDao;
    }
}
