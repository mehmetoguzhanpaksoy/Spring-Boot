import bist.nomx.filewatcher.service.Spring.Configuration.AppConfiguration;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

@SpringBootApplication
@EnableConfigurationProperties(MyProperties.class)
public class App  {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(App.class, args);
        AppConfiguration beans = context.getBean(AppConfiguration.class);
       System.out.println(String.valueOf(beans.port));
    }

    @Bean
    ApplicationRunner applicationRunner (MyProperties myproperties) {
        return args -> {
            System.out.println(myproperties);
        };
    }



}
