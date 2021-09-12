package demo.codesgrammr.dao;

public class ShipmentOrderDao {

    public void findShipmentOrder(long shipmentOrderId) {
        System.out.println(this.getClass().getSimpleName() + " Find Shipment order with id " + shipmentOrderId);
    }
}
