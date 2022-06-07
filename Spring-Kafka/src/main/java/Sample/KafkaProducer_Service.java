package Sample;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import javax.annotation.PostConstruct;
import java.util.Properties;

public class KafkaProducer_Service {

    Producer producer;
    @PostConstruct
    public void init(){
        Properties config=new Properties();

        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,new StringSerializer().getClass().getName());
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,new StringSerializer().getClass().getName());

        producer=new KafkaProducer<String,String>(config);
    }
    public void send(String term) {
        ProducerRecord<String,String> rec=new ProducerRecord<String, String>("oguzhan",term);
        producer.send(rec);
    }

    public void close(){
        producer.close();
    }
}
