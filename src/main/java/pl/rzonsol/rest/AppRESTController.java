package pl.rzonsol.rest;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import pl.rzonsol.domain.Comment;
import pl.rzonsol.domain.News;
import pl.rzonsol.service.CommentService;
import pl.rzonsol.service.NewsService;

import javax.validation.Valid;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by rzonsol on 06.01.2017.
 */
@RestController
@RequestMapping("/api/news")
public class AppRESTController {

    private final CommentService commentService;

    private final NewsService newsService;

    Map<String,Object> response = new LinkedHashMap<>();

    public AppRESTController(CommentService commentService, NewsService newsService) {
        this.commentService = commentService;
        this.newsService = newsService;
    }

    @CrossOrigin(value = "*")
    @RequestMapping(method = RequestMethod.GET, value = "/getNews")
    public @ResponseBody List<News> findAll(){
        return  newsService.getObj();
    }

    @CrossOrigin(value = "*")
    @RequestMapping(method = RequestMethod.GET, value = "/getNewsById/{id}")
    public @ResponseBody News findById(@PathVariable String id){
        return newsService.findById(id);
    }
    @CrossOrigin(value = "*")
    @RequestMapping(method = RequestMethod.GET, value = "/getCommentsByNewsId/{id}")
    public @ResponseBody List<Comment> findCommentsById(@PathVariable String id){
        return commentService.findCommentsById(id);
    }

    @CrossOrigin(value = "*")
    @RequestMapping(method = RequestMethod.POST, value = "/getNews")
    public @ResponseBody Map<String,Object> create(@Valid @RequestBody News news, BindingResult bindingResult){

        if (checkErrors(bindingResult)){
            newsService.create(news);
            response.put("message","News created successfully!!");
            response.put("news", newsService.create(news));
        }
        return response;
    }

    @CrossOrigin(value = "*")
    @RequestMapping(method = RequestMethod.GET, value = "/getComment")
    public @ResponseBody List<Comment> findAllComment(){
        return  commentService.getObj();
    }

    @CrossOrigin(value = "*")
    @RequestMapping(method = RequestMethod.POST, value = "/getCommentsByNewsId/{id}")
    public @ResponseBody Map<String,Object> create(@Valid @RequestBody  Comment comment, BindingResult bindingResult,@PathVariable String id){

        if (checkErrors(bindingResult)){
            commentService.create(comment);
            response.put("message", "Comment has been added!!");
            response.put("comment",commentService.create(comment));
        }
        return response;
    }

    private Boolean checkErrors(BindingResult bindingResult){

        boolean result=false;
        if (bindingResult.hasErrors()){
            List<FieldError> errors = bindingResult.getFieldErrors();
            response.put("message","Error");
            for (FieldError error :errors) {
                response.put(error.getField(),error.getDefaultMessage());
                result= false;
            }
        }else{
            result = true;
        }
        return result;
    }
}
