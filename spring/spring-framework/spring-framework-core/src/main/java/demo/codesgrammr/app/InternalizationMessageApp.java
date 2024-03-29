package demo.codesgrammr.app;

import demo.codesgrammr.property.InternalizedMessages;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Locale;

public class InternalizationMessageApp {

    private ApplicationContext applicationContext;

    public static void main(String[] args) {
        InternalizationMessageApp appMessageApp = new InternalizationMessageApp();
        appMessageApp.initializeApp();
    }

    private void initializeApp() {
        applicationContext = new ClassPathXmlApplicationContext("internalization-context.xml");
        assert applicationContext != null;


        InternalizedMessages internalizedAppMessage = applicationContext.getBean(InternalizedMessages.class);
        assert internalizedAppMessage != null;

        internalizedAppMessage.showSuccessMessages(Locale.ENGLISH);
        internalizedAppMessage.showSuccessMessages(Locale.CHINESE);

        internalizedAppMessage.showFailMessage(Locale.ENGLISH);
        internalizedAppMessage.showFailMessage(Locale.CHINESE);
    }
}
