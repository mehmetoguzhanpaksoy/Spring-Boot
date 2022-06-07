
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("my-properties")
@Data
public class MyProperties {
    private String host;
    private int port;
}
