package demo.codesgrammr.factory;

import demo.codesgrammr.dao.ShipmentOrderDao;

public class ShipmentOrderFactory {

    private static ShipmentOrderDao shipmentOrderDao = new ShipmentOrderDao();

    public ShipmentOrderDao createShipmentOrderDao() {
        return shipmentOrderDao;
    }
}
