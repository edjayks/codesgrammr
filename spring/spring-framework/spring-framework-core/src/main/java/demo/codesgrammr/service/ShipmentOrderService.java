package demo.codesgrammr.service;

import demo.codesgrammr.dao.ShipmentOrderDao;

public class ShipmentOrderService {

    private ShipmentOrderDao shipmentOrderDao;

    public ShipmentOrderService(ShipmentOrderDao shipmentOrderDao) {
        this.shipmentOrderDao = shipmentOrderDao;
    }

    public void findShipmentOrder(long shipmentOrderId) {
        System.out.println(this.getClass().getSimpleName() + " Find shipment order with id " + shipmentOrderId);

        shipmentOrderDao.findShipmentOrder(shipmentOrderId);
    }
}
