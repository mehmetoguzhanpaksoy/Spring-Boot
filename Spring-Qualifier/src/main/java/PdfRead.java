import org.springframework.stereotype.Component;

@Component("PDF")
public class PdfRead implements Read{
    @Override
    public String readfile() {
        return "PDFread";
    }
}

