package pl.rzonsol;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import pl.rzonsol.domain.Comment;
import pl.rzonsol.domain.News;
import pl.rzonsol.service.CommentService;
import pl.rzonsol.service.NewsService;

@SpringBootApplication
@Configuration
@ComponentScan
public class NewsSystemApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(NewsSystemApplication.class, args);
	}

	@Autowired
	public NewsService newsService;

	@Autowired
	public CommentService commentService;
	@Override
	public void run(String... args) throws Exception {


	}
}

//
//start mongodb
//		 mongod --dbpath c:/mongodb/data/db
// 		 mongo-express -u rzonsol -p abc123 -d newssystemservice
