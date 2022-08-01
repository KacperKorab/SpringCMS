package pl.coderslab.article;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class ArticleDao {

    public List<Article> getAllArticles() {
        return entityManager
                .createQuery("select a from Article a")
                .getResultList();
    }

    @PersistenceContext
    EntityManager entityManager;

    public void saveArticle(Article article){
        entityManager.persist(article);
    }
    public void deleteArticle(Article article){
        entityManager.remove(entityManager.contains(article) ?
                article : entityManager.merge(article));
    }
    public void editArticle(Article article){
        entityManager.merge(article);
    }
}
