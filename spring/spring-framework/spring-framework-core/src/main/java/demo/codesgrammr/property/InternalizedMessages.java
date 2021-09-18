package demo.codesgrammr.property;

import org.springframework.context.MessageSource;

import java.util.Locale;

public class InternalizedMessages {

    private MessageSource messageSource;

    // setter method for Spring to inject message source
    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public void showSuccessMessages(Locale locale) {
        System.out.println(messageSource.getMessage("success.msg", new Object[] {"Show"}, "=.=|||", locale));
    }

    public void showFailMessage(Locale locale) {
        System.out.println(messageSource.getMessage("fail.msg", new Object[0], "=.=|||", locale));
    }
}
