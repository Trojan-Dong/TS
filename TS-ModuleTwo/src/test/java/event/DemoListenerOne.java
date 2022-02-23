package event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class DemoListenerOne implements ApplicationListener<DemoEventOne> {
    @Override
    public void onApplicationEvent(DemoEventOne event) {
        System.out.println(event.getMsg());
        System.out.println("--------------------");
    }
}
