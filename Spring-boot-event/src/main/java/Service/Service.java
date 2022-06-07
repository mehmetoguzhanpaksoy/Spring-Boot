package Service;

import Api.Controller;
import evetn.CreatorEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.scheduling.annotation.Async;

@org.springframework.stereotype.Service
public class Service {

    @Autowired
    ApplicationEventPublisher applicationEventPublisher;

    @Async
    public void publishReservationEvent(Controller.HotelBookRequest hotelBookRequest){
     applicationEventPublisher.publishEvent( new CreatorEvent(hotelBookRequest));
    }
}
