package pl.rzonsol.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by rzonsol on 03.01.2017.
 */

@Document
public class News {

    @Id
    private String id;

    @NotNull(message = "Field can not be empty")
    @Size(min=5, max = 70, message = "Number of character have to be between 5-70 characters")
    private String title;

    @NotNull(message = "Field can not be empty")
    @Size(min=5, message = "Number of character must be greater then 5 characters")
    private String text;

//    @NotNull(message = "Field can not be empty")
    private String data;

    @NotNull(message = "Field can not be empty")
    @Size(min=1, message = "Number of character must be greater then 1 character")
    private String author;

    public News() {}

    public News(String title, String text, String data, String author) {
        this.title = title;
        this.text = text;
        this.data = data;
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
