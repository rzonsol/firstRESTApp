package pl.rzonsol.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pl.rzonsol.domain.News;

/**
 * Created by rzonsol on 03.01.2017.
 */

@Repository
public interface NewsRepository extends MongoRepository<News,String> {
}
