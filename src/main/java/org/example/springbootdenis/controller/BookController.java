package org.example.springbootdenis.controller;

import jakarta.validation.Valid;
import org.example.springbootdenis.dto.request.BookRequest;
import org.example.springbootdenis.dto.response.BookResponse;
import org.example.springbootdenis.service.BookService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/save")
    public ResponseEntity<BookResponse> saveBook(@RequestBody @Valid BookRequest bookRequest) {
        return ResponseEntity.ok(bookService.save(bookRequest));
    }

    @GetMapping("/listAll")
    public ResponseEntity<Page<BookResponse>> showAll(Pageable pageable) {
        return ResponseEntity.ok(bookService.showAll(pageable));
    }

    @GetMapping("/findBook/{id}")
    public ResponseEntity<BookResponse> findBookById(@PathVariable int id) {
        return ResponseEntity.ok(bookService.findBookById(id));
    }

    @GetMapping("/findAllBooks/{name}")
    public ResponseEntity<List<BookResponse>> findAllBooks(@PathVariable String name) {
        return ResponseEntity.ok(bookService.findAllBooks(name));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable int id) {
        bookService.deleteBook(id);
        return ResponseEntity.ok().build();
    }
}
