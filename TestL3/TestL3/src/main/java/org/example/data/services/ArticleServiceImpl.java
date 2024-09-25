package org.example.data.services;

import java.util.List;
import org.example.data.entities.Article;
import org.example.data.repositories.ArticleRepository;

public class ArticleServiceImpl {
    private final ArticleRepository articleRepository = new ArticleRepository();

    public List<Article> findAvailableArticles() {
        return articleRepository.selectAll().stream()
                .filter(Article::isAvailable)
                .toList();
    }

    public void createArticle(Article article) {
        articleRepository.insert(article);
    }

    public void updateArticleStock(String name, int newStock) {
        Article article = articleRepository.selectByName(name);
        if (article != null) {
            article.setQteStock(newStock);
            articleRepository.update(article);
        }
    }
}
