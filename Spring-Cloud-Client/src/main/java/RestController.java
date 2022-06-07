import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @GetMapping("/list")
    public List<Movie> getallMovies(){
        List<Movie> movies=new ArrayList<Movie>();
        movies.add(new Movie("Kelebek Etkisi", "2004", "7,7"));
        movies.add(new Movie("Zamanın Ötesinde", "2014", "7,5"));
        return  movies;
    }
}
