package pl.coderslab.article;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import pl.coderslab.author.Author;
import pl.coderslab.category.Category;

import java.util.Date;
import java.util.List;

@Entity
@Table(name="articles")
@Getter
@Setter
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 200)
    private String title;
    @OneToOne
    private Author author;
    @OneToMany
    private List<Category> categories;
    private String content;
    @CreationTimestamp
    private Date created;
    @UpdateTimestamp
    private Date updated;
}
