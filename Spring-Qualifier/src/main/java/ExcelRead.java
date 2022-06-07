import org.springframework.stereotype.Component;

@Component
public class ExcelRead implements Read {

    @Override
    public String readfile() {
        return "Excel Read";
    }
}
