package projects.bing.service;

import org.springframework.stereotype.Service;
import projects.bing.entity.Article;

import java.util.List;

@Service
public interface ArticleService extends BaseService<Article> {

    List<Article> getByTheme(String id);
}
