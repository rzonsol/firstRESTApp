package pl.rzonsol.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pl.rzonsol.domain.Comment;

import java.util.List;

/**
 * Created by rzonsol on 03.01.2017.
 */

@Repository
public interface CommentRepository extends MongoRepository<Comment,String > {

    List<Comment> findCommentsByNewsId(String id);
}
