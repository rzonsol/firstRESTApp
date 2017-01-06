package pl.rzonsol.config;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * Created by rzonsol on 03.01.2017.
 */
@Configuration
@EnableMongoRepositories("pl.rzonsol.repository")
public class DatabaseConfiguration extends AbstractMongoConfiguration{

    @Value("${spring.data.mongodb.host}")
    private String host;

    @Value("${spring.data.mongodb.port}")
    private Integer port;

    @Value("${spring.data.mongodb.username}")
    private String userName;

    @Value("${spring.data.mongodb.password}")
    private String password;

    @Value("${spring.data.mongodb.database}")
    private String database;
    @Override
    protected String getDatabaseName() {
        return database;
    }

    @Override
    public Mongo mongo() throws Exception {
        return new MongoClient(host+":"+port);
    }
}
