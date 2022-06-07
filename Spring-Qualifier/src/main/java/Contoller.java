import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class Contoller {

    @Autowired
    @Qualifier("excelRead")
    private Read read;

    @Qualifier("pdfread")
    private Read read1;

    @GetMapping("/read")
    public String read(){
        return this.read.readfile();
    }

    @GetMapping("/read")
    public String reader(){
        return this.read1.readfile();
    }
}
