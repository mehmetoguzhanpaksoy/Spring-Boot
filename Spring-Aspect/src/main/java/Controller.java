import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("")
public class Controller {

    @Autowired
    Service service;

    @GetMapping("/hello/{kisi}")
    public  String getreturn(@PathVariable String kisi){
        return service.mesaj(kisi);
    }
    @GetMapping("/hello1/{kisi}")
    public  String getreturn1(@PathVariable String kisi){
        return service.mesajVer(kisi);
    }

}
