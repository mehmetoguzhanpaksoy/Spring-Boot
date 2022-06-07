package Config;

import model.Student;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;


@Configuration
@EnableBatchProcessing
public class BatchConfiguration {
    @Autowired
    private StepBuilderFactory stepBuilderFactory;
    @Autowired
    private JobBuilderFactory jobBuilderFactory;
    @Autowired
    private DataSource dataSource;

    @Autowired
    private JdbcCursorItemReader<Student> reader(){
        JdbcCursorItemReader<Student> reader= new JdbcCursorItemReader<Student>();
        reader.setDataSource(dataSource);
        reader.setSql("Select id,firstname,lastname,email from csvtodbdata");
        reader.setRowMapper(new RowMapper<Student>() {
            @Override
            public Student mapRow(ResultSet resultSet, int i) throws SQLException {
                Student s=new Student();
                s.setId(resultSet.getInt("id"));
                s.setFirstName(resultSet.getString("firstname"));
                s.setLastname(resultSet.getString("lastname"));
                s.setEmail(resultSet.getString("email"));
                return  s;
            }
        });
        return reader;
    }

    @Bean
    public FlatFileItemWriter<Student> writer(){

        FlatFileItemWriter<Student> ItemWriter = new FlatFileItemWriter<>();
        ItemWriter.setResource(new FileSystemResource("Dosyanın çıkarılacağı path"));

        DelimitedLineAggregator<Student> Aggregator = new DelimitedLineAggregator<>();
        BeanWrapperFieldExtractor<Student> FieldExtractor = new BeanWrapperFieldExtractor<>();

        FieldExtractor.setNames(new String[] {"id","firstname","lastname","email"});
        Aggregator.setFieldExtractor(FieldExtractor);

        ItemWriter.setLineAggregator(Aggregator);
        return ItemWriter;
    }

    @Bean
    public Step executeStep(){
        return stepBuilderFactory.get("executeStep").<Student,Student>chunk(10).reader(reader()).writer(writer()).build();
    }
    @Bean
    public Job processorJob(){
       return jobBuilderFactory. get("processorJob").incrementer(new RunIdIncrementer()).flow(executeStep()).end().build();
    }
}
