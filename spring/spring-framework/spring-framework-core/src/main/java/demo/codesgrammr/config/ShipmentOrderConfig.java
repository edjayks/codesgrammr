package demo.codesgrammr.config;

import demo.codesgrammr.dao.ShipmentOrderDao;
import demo.codesgrammr.service.ShipmentOrderService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ShipmentOrderConfig {

    @Bean
    public ShipmentOrderService shipmentOrderService() {
        return new ShipmentOrderService(shipmentOrderDao());
    }

    @Bean
    public ShipmentOrderDao shipmentOrderDao() {
        return new ShipmentOrderDao();
    }
}
