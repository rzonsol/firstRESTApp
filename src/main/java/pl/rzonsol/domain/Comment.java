package pl.rzonsol.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by rzonsol on 03.01.2017.
 */

@Document
public class Comment {

    @Id
    private String id;

    @NotNull(message = "Can not be empty")
    private String newsId;

    @NotNull( message = "Can not be empty")
    @Size(min=5, max=2000, message =  "Number of character must be greater then 2 characters and less then 2000 characters")
    private String comment;

    @NotNull(message = "Can not be empty")
    @Size(min=5, message = "Number of character must be greater then 5 characters")
    private String author;

    @NotNull(message = "Can not be empty")
    private String date;

    public Comment(String newsId, String comment, String author, String date) {
        this.newsId = newsId;
        this.comment = comment;
        this.author = author;
        this.date = date;
    }

    public Comment() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNewsId() {
        return newsId;
    }

    public void setNewsId(String newsId) {
        this.newsId = newsId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
