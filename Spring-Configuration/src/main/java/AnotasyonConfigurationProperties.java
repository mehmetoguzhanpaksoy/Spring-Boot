import bist.nomx.filewatcher.service.Spring.Configuration.AppConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnotasyonConfigurationProperties {
    @Autowired
    AppConfiguration appConfiguration;

    public String getPropertiesHost(){
        return appConfiguration.host;
    }
    public String getPropertiesPort(){
        return String.valueOf(appConfiguration.port);
    }
}
