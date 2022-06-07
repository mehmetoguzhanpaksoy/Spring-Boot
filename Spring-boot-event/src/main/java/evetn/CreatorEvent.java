package evetn;

import org.springframework.context.ApplicationEvent;

public class CreatorEvent extends ApplicationEvent {
    public CreatorEvent(Object source) {
        super(source);
    }
}
