package demo.codesgrammr.setter;

import demo.codesgrammr.dao.ShipmentOrderDao;

public class ShipmentOrderSetterImpl {

    private ShipmentOrderDao shipmentOrderDao;

    //Just a normal setter method that Spring will call to inject bean
    public void setShipmentOrderDao(ShipmentOrderDao shipmentOrderDao) {
        this.shipmentOrderDao = shipmentOrderDao;
    }

    public void updateShipmentOrder(long shipmentOrderId) {
        System.out.println("Update shipment order with id " + shipmentOrderId);
        shipmentOrderDao.findShipmentOrder(shipmentOrderId);
    }
}
