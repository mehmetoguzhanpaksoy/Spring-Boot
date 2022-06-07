import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

    @RequestMapping("/user")
    public String loginUser(){
        return "User kullanıcı girişi başarılı";
    }

    @RequestMapping("/admin")
    public String loginAdmin(){
        return "Admin kullanıcı girişi başarılı";
    }

    @RequestMapping("/index")
    public String loginindex(){
        return "İndex Sayfasına giriş başarılı";
    }


}