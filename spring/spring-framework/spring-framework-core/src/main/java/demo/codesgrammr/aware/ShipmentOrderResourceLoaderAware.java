package demo.codesgrammr.aware;

import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.ResourceLoader;

public class ShipmentOrderResourceLoaderAware implements ResourceLoaderAware {

    ResourceLoader resourceLoader;

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    public void fetchMailTemplate() {
        System.out.println(resourceLoader.getResource("mail_template.txt"));

        System.out.println(resourceLoader.getResource("classpath:mail_template.txt"));
    }
}
