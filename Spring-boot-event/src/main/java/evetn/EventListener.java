package evetn;

import org.springframework.stereotype.Component;

@Component
public class EventListener {

    @org.springframework.context.event.EventListener
    public void reservationEventHandler(CreatorEvent creatorEvent) throws InterruptedException {
        Thread.sleep(5000l);
        System.out.println("EventListener ->"+creatorEvent.getSource().toString());
    }
}
