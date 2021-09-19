package demo.codesgrammr.app;

import demo.codesgrammr.aware.ShipmentOrderResourceLoaderAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ShipmentOrderResourceXmlApp {

    private ApplicationContext applicationContext;

    public static void main(String[] args) {
        ShipmentOrderResourceXmlApp shipmentOrderResourceApp = new ShipmentOrderResourceXmlApp();
        shipmentOrderResourceApp.initiateApp();
    }

    private void initiateApp() {
        applicationContext = new AnnotationConfigApplicationContext(ShipmentOrderResourceLoaderAware.class);
        assert applicationContext != null;

        System.out.println("Resource type: " + applicationContext.getResource("mail_template.txt"));

        System.out.println("Resource type: " + applicationContext.getResource("classpath:mail_template.txt"));

        ShipmentOrderResourceLoaderAware shipmentOrderResourceLoaderAware =
                applicationContext.getBean(ShipmentOrderResourceLoaderAware.class);
        assert shipmentOrderResourceLoaderAware != null;

        shipmentOrderResourceLoaderAware.fetchMailTemplate();
    }
}
