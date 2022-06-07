package Sample;




import com.sun.jmx.snmp.Timestamp;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@RestController
public class KafkaProducer_Controller {
    @Autowired
    private KafkaProducer_Service kafkaProducer_service;

    @GetMapping("/search")
    public void searchındex(@RequestParam String term)   {
        List<String> cities= Arrays.asList("Ankara","İstanbul","Trabzon","Bayburt","Sakarya");
        Timestamp timestamp=new Timestamp(System.currentTimeMillis());
        Random random=new Random();
        int i=random.nextInt(cities.size());
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("search",term);
        jsonObject.put("timestamp",timestamp);
        jsonObject.put("region",cities.get(i));
        System.out.println(jsonObject.toJSONString());
        // System.out.println(term+" "+timestamp+" "+cities.get(i));
        kafkaProducer_service.send(jsonObject.toJSONString());
    }
}
