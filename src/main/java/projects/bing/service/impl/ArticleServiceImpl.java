package projects.bing.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projects.bing.dao.ArticleDao;
import projects.bing.entity.Article;
import projects.bing.service.ArticleService;

import java.util.List;
@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleDao articleDao;

    @Override
    public List<Article> getByTheme(String id) {
        return articleDao.getByTheme(id);
    }

    @Override
    public int add(Article article) {
        return articleDao.add(article);
    }

    @Override
    public int delete(String id) {
        return articleDao.delete(id);
    }

    @Override
    public int update(Article article) {
        return articleDao.update(article);
    }

    @Override
    public Article getOne(String id) {
        return articleDao.getOne(id);
    }

    @Override
    public List<Article> getAll() {
        return articleDao.getAll();
    }
}
