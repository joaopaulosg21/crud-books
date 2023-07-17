package aprendendo.api.crudbooks.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import aprendendo.api.crudbooks.model.Book;
import aprendendo.api.crudbooks.service.BookService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/books")
@AllArgsConstructor
public class BookController {
    
    private final BookService bookService;

    @PostMapping("/")
    public ResponseEntity<Book> create(@RequestBody Book book) {
        return ResponseEntity.status(HttpStatus.CREATED).body(bookService.create(book));
    }

    @GetMapping("/")
    public ResponseEntity<List<Book>> find() {
        return ResponseEntity.ok(bookService.find());
    }

    @PatchMapping("/{bookId}")
    public ResponseEntity<Book> update(@PathVariable Long bookId, @RequestBody Book book) {
        return ResponseEntity.ok(bookService.update(bookId, book));
    }

    @DeleteMapping("/{bookId}")
    public ResponseEntity<List<Book>> update(@PathVariable Long bookId) {
        return ResponseEntity.ok(bookService.delete(bookId));
    }
}
