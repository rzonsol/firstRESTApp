package pl.rzonsol.service;

import org.springframework.stereotype.Service;
import pl.rzonsol.domain.Comment;
import pl.rzonsol.repository.CommentRepository;

import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Created by rzonsol on 04.01.2017.
 */
@Service
public class CommentService implements ServiceInterface<Comment>, CustomInterfaceComment  {

    private CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public List<Comment> getObj() {
        List<Comment> commentList =commentRepository.findAll();
        return convertToDTOs(commentList);
    }

    private List<Comment> convertToDTOs(List<Comment> models) {
        return models.stream().map(this::convertToDTO).collect(toList());
    }

    private Comment convertToDTO(Comment model) {

        Comment dto = new Comment();
        dto.setId(model.getId());
        dto.setAuthor(model.getAuthor());
        dto.setComment(model.getComment());
        dto.setNewsId(model.getNewsId());
        dto.setDate(model.getDate());
        return dto;
    }

    @Override
    public Comment create(Comment obj) {
        return commentRepository.save(obj);
    }

    @Override
    public Comment findById(String id) {
        return null;
    }

    @Override
    public Comment update(Comment obj) {
        return null;
    }

    @Override
    public List<Comment> findCommentsById(String id) {
        List<Comment> commentList = commentRepository.findCommentsByNewsId(id);
        return  convertToDTOs(commentList);
    }
}
