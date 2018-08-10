package projects.bing.dao;

import projects.bing.entity.Article;

import java.util.List;

public interface ArticleDao extends BaseDao<Article> {

    List<Article> getByTheme(String themeid);
}
