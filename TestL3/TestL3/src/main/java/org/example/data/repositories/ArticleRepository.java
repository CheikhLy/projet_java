package org.example.data.repositories;

import org.example.data.entities.Article;
import java.util.ArrayList;
import java.util.List;

public class ArticleRepository {
    private final List<Article> articleList = new ArrayList<>();

    public void insert(Article article) {
        articleList.add(article);
    }

    public List<Article> selectAll() {
        return articleList;
    }

    public Article selectByName(String name) {
        return articleList.stream()
                .filter(article -> article.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    public void update(Article article) {
        Article existingArticle = selectByName(article.getName());
        if (existingArticle != null) {
            existingArticle.setQteStock(article.getQteStock());
        }
    }
}
