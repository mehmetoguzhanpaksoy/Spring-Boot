import lombok.Data;

@Data
public class Movie {

    private String name;
    private String date;
    private String imdbPoint;

    public Movie(String s1, String s2, String s3) {
        this.name=s1;
        this.date=s2;
        this.imdbPoint=s3;
    }
}
