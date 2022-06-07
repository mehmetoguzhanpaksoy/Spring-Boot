package Api;

import Service.Service;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

@org.springframework.stereotype.Controller()
public class Controller {

    @Autowired
    Service service;


    public void bookhotel(@RequestBody HotelBookRequest hotelBookRequest){
          service.publishReservationEvent(hotelBookRequest);
          System.out.println("İşlem isteği alındı ");
    }


    @Data
    @ToString
    @NoArgsConstructor
    @AllArgsConstructor
    public class HotelBookRequest{
        private String userıd;
        private String hotelıd;
    }
}
