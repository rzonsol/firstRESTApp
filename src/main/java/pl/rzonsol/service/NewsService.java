package pl.rzonsol.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.rzonsol.domain.News;
import pl.rzonsol.repository.NewsRepository;

import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Created by rzonsol on 04.01.2017.
 */

@Service
public class NewsService implements ServiceInterface<News> {

    private NewsRepository newsRepository;

    @Autowired
    public NewsService(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    @Override
    public List<News> getObj() {
        List<News> newsList= newsRepository.findAll();
        return convertToDTOs(newsList);
    }

    private List<News> convertToDTOs(List<News> models){
        return models.stream().map(this::convertToDTO).collect(toList());
    }

    private News convertToDTO(News model) {

        News dto = new News();
        dto.setData(model.getData());
        dto.setId(model.getId());
        dto.setText(model.getText());
        dto.setTitle(model.getTitle());
        dto.setAuthor(model.getAuthor());
        return dto;
    }

    @Override
    public News create(News obj) {
        return newsRepository.save(obj);
    }

    @Override
    public News findById(String id) {
        return null;
    }

    @Override
    public News update(News obj) {
        return null;
    }
}
