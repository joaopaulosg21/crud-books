package aprendendo.api.crudbooks.service;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import aprendendo.api.crudbooks.exceptions.BookNotFoundException;
import aprendendo.api.crudbooks.model.Book;
import aprendendo.api.crudbooks.repository.BookRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public Book create(Book book) {
        return bookRepository.save(book);
    }

    public List<Book> find() {
        Sort sort = Sort.by("createdAt","id").descending();
        return bookRepository.findAll(sort);
    }

    public Book update(Long id, Book updateBook) {
        Book book = bookRepository.findById(id).orElseThrow(BookNotFoundException::new);

        book.setAuthor(updateBook.getAuthor());
        book.setTitle(updateBook.getTitle());
        book.setDescription(updateBook.getDescription());

        return bookRepository.save(book);

    }

    public List<Book> delete(Long id) {
        Book book = bookRepository.findById(id).orElseThrow(BookNotFoundException::new);

        bookRepository.delete(book);

        return this.find();
    }
}
