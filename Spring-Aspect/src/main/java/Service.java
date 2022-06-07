import org.springframework.stereotype.Component;

@org.springframework.stereotype.Service
public class Service {

    public String mesajVer(String param) {
        System.out.println("Metod mesaj verdi param: " + param);
        return param;
    }

    public String mesaj(String param) {
        System.out.println(param);
        return param;
    }
}
