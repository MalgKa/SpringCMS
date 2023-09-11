package app.dao;

import app.entity.Article;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class ArticleDao {
    @PersistenceContext
    EntityManager entityManager;

    public void save(Article article) {
        entityManager.persist(article);
    }

    public void update(Article article) {
        entityManager.merge(article);
    }

    public void delete(Article article) {
        entityManager.remove(entityManager.contains(article) ? article : entityManager.merge(article));
    }

    public Article findById(Long id) {
        return entityManager.find(Article.class, id);
    }

    public List<Article> findAll(){
        return entityManager.createQuery("SELECT a FROM Article a", Article.class).getResultList();
    }

    public List<Article> last5(){
        return entityManager.createQuery("SELECT a FROM Article a ORDER BY created DESC", Article.class)
                .setMaxResults(5)
                .getResultList();
    }
}
