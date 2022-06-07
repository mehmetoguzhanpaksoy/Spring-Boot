package Controller;

import Model.Kmessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/kmessage")
public class Contoller {

    @Value("${haydikodlayalim.kafka.topic}")
    private String topic;

    private final KafkaTemplate<String, Kmessage> kafkaTemplate;

    public Contoller(String topic, KafkaTemplate<String, Kmessage> kafkaTemplate) {
        this.topic = topic;
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping //http://localhost:8047/kmessage
    public void sendMessage(@RequestBody Kmessage kMessage) {
        kafkaTemplate.send(topic, UUID.randomUUID().toString(), kMessage);
    }

}
