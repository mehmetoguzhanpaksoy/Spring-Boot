import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class,args);
    }

    @Scheduled(fixedRate = 2000l)
    void Somejobs() throws InterruptedException {
        System.out.println("Now is "+ new Date());
        Thread.sleep(1000l);
    }
}
