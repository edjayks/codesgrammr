package demo.codesgrammr.bean;

public class ShipmentOrder {

    private long shipmentOrderId;

    private long shipmentId;

    private long orderId;

    private long customerId;

    public long getShipmentOrderId() {
        return shipmentOrderId;
    }

    public void setShipmentOrderId(long shipmentOrderId) {
        this.shipmentOrderId = shipmentOrderId;
    }

    public long getShipmentId() {
        return shipmentId;
    }

    public void setShipmentId(long shipmentId) {
        this.shipmentId = shipmentId;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }
}
