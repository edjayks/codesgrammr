package demo.codesgrammr.app;

import demo.codesgrammr.config.MySqlConnPropertiesConfig;
import demo.codesgrammr.property.JavaPrimitiveDataTypesProperties;
import demo.codesgrammr.property.JavaWrapperDataTypesProperties;
import demo.codesgrammr.property.MySqlConnectionProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ShipmentOrderMySqlPropXmlApp {

    private ApplicationContext applicationContext;

    public static void main(String[] args) {
        ShipmentOrderMySqlPropXmlApp shipmentOrderMySqlPropXmlApp = new ShipmentOrderMySqlPropXmlApp();

        shipmentOrderMySqlPropXmlApp.initiateSpringApp();
    }

    private void initiateSpringApp() {
        applicationContext = new AnnotationConfigApplicationContext(
                MySqlConnPropertiesConfig.class,
                MySqlConnectionProperties.class,
                JavaPrimitiveDataTypesProperties.class,
                JavaWrapperDataTypesProperties.class);

        assert applicationContext != null;

        MySqlConnectionProperties mySqlConnectionProperties = applicationContext.getBean(MySqlConnectionProperties.class);
        assert mySqlConnectionProperties != null;
        System.out.println(mySqlConnectionProperties);

        JavaPrimitiveDataTypesProperties javaDataTypesProperties =
                applicationContext.getBean(JavaPrimitiveDataTypesProperties.class);
        assert javaDataTypesProperties != null;
        System.out.println(javaDataTypesProperties);

        JavaWrapperDataTypesProperties javaWrapperDataTypesProperties =
                applicationContext.getBean(JavaWrapperDataTypesProperties.class);
        assert javaWrapperDataTypesProperties != null;
        System.out.println(javaWrapperDataTypesProperties);
    }

}
