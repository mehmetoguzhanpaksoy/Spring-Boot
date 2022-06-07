import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Scheduling {

    @Scheduled(cron = "* * * * * *",zone = "Europe/Istanbul")
    public void tasks(){
        System.out.println("task 1");
    }

}

