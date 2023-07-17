package aprendendo.api.crudbooks.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import aprendendo.api.crudbooks.model.Book;

public interface BookRepository extends JpaRepository<Book,Long>{
    
}
