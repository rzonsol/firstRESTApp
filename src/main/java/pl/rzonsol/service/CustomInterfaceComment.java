package pl.rzonsol.service;

import pl.rzonsol.domain.Comment;

import java.util.List;

/**
 * Created by rzonsol on 04.01.2017.
 */
public interface CustomInterfaceComment {

    List<Comment> findCommentsById(String id);
}
