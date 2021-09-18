package demo.codesgrammr.listener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class AllEventListener implements ApplicationListener {

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        // You will need to check the event type yourself and cast it yourself
        System.out.println(getClass().getSimpleName() + " Received event: " + event);
    }
}
