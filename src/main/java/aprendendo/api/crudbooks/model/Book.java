package aprendendo.api.crudbooks.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "books")
@Getter @Setter
@EntityListeners(AuditingEntityListener.class)
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String author;

    private String description;

    @CreatedDate
    private LocalDate createdAt;

    @UpdateTimestamp
    private LocalDate updatedAt;

    public Book(String title, String author, String description) {
        this.title = title;
        this.author = author;
        this.description = description;
    }

    public Book(Long id, String title, String author, String description) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.description = description;
    }

    public Book() {}

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;

        if(obj instanceof Book) {
            Book b = (Book) obj;

            if(b.getId() == this.id && b.getAuthor() == this.author && b.getTitle() == this.title && b.getDescription() == this.description) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Book [id=" + id + ", title=" + title + ", author=" + author + ", description=" + description
                + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
    }

    
}
