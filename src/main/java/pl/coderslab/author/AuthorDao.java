package pl.coderslab.author;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import pl.coderslab.author.Author;

import java.util.List;

@Repository
@Transactional
public class AuthorDao {

    public List<Author> getAllAuthors() {
        return entityManager
                .createQuery("select a from Author a")
                .getResultList();
    }

    @PersistenceContext
    EntityManager entityManager;

    public void saveAuthor(Author author){
        entityManager.persist(author);
    }
    public void deleteAuthor(Author author){
        entityManager.remove(entityManager.contains(author) ?
                author : entityManager.merge(author));
    }
    public void editAuthor(Author author){
        entityManager.merge(author);
    }
}
