package projects.bing.service.impl;

import org.springframework.stereotype.Service;
import projects.bing.entity.Article;
import projects.bing.service.ArticleService;

import java.util.List;
@Service
public class ArticleServiceImpl implements ArticleService {
    @Override
    public List<Article> getByTheme(String id) {
        return null;
    }

    @Override
    public int add(Article article) {
        return 0;
    }

    @Override
    public int delete(String id) {
        return 0;
    }

    @Override
    public int update(Article article) {
        return 0;
    }

    @Override
    public Article getOne(String id) {
        return null;
    }

    @Override
    public List<Article> getAll() {
        return null;
    }
}
