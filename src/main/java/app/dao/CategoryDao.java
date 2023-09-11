package app.dao;


import app.entity.Category;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CategoryDao {
    @PersistenceContext
    EntityManager entityManager;

    public void save(Category category) {
        entityManager.persist(category);
    }

    public void update(Category category) {
        entityManager.merge(category);
    }

    public void delete(Category category) {
        entityManager.remove(entityManager.contains(category) ? category : entityManager.merge(category));
    }

    public Category findById(Long id) {
        return entityManager.find(Category.class, id);
    }
    public List<Category> findAll(){
        return entityManager.createQuery("SELECT c FROM Category c", Category.class).getResultList();
    }
}
