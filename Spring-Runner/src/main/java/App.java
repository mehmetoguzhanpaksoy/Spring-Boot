import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.nio.file.Paths;
import java.util.Calendar;

@SpringBootApplication
@EnableConfigurationProperties(myproperties.class)
public class App implements CommandLineRunner{

    public static void main(String[] args) {
        SpringApplication.run(App.class,args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("message");
    }


    @Bean
    ApplicationRunner applicationRunner (myProperties myproperties) {
        return args -> {
            System.out.println(myproperties);

        };
    }

    @Bean
    CommandLineRunner commandLineRunner() {
        return args -> {
            System.out.println("message");
        };
    }



}
