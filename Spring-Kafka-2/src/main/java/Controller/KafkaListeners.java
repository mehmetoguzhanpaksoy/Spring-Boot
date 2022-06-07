package Controller;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {

    @KafkaListener(topics = "oguzhan")
    void listeners(String data){
        System.out.println("Received data"+data+":)");
    }
}
