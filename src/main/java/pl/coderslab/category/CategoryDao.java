package pl.coderslab.category;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class CategoryDao {

    @PersistenceContext
    EntityManager entityManager;

    public List<Category> getAllCategories() {
        return entityManager
                .createQuery("select c from Category c")
                .getResultList();
    }

    public void saveCategory(Category category){
        entityManager.persist(category);
    }
    public void deleteCategory(Category category){
        entityManager.remove(entityManager.contains(category) ?
                category : entityManager.merge(category));
    }
    public void editCategory(Category category){
        entityManager.merge(category);
    }
}
