package bist.nomx.filewatcher.service.Spring.Configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {

    @Value("${my-properties.host}")
    public String host;

    @Value("${my-properties.port}")
    public int port;

}
