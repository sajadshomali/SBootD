package org.example.springbootdenis.service;

import org.example.springbootdenis.dto.request.BookRequest;
import org.example.springbootdenis.dto.response.BookResponse;
import org.example.springbootdenis.exceptions.MyExceptionRules;
import org.example.springbootdenis.model.Book;
import org.example.springbootdenis.repository.BookRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public BookResponse save(BookRequest bookRequest) {
        Optional<Book> byName = bookRepository.findByName(bookRequest.getName());
        if (!byName.isEmpty())
            throw new MyExceptionRules("Book.is.exist");

        return createBookResponse(bookRepository.save(createBook(bookRequest)));
    }

    @Override
    public Page<BookResponse> showAll(Pageable pageable) {
        return bookRepository.findAll(pageable).map(book->
        BookResponse.builder().id(book.getId()).
                name(book.getName()).
                price(book.getPrice()).
                build());
    }

    @Override
    public BookResponse findBookById(int id) {
        return createBookResponse(bookRepository.findById(id).
                orElseThrow(()->
                        new MyExceptionRules("The.book.not.exist")));
    }

    @Override
    public List<BookResponse> findAllBooks(String name) {
        return bookRepository.findAllBooks(name).stream().map(book->
                BookResponse.builder().id(book.getId())
                        .name(book.getName())
                        .price(book.getPrice())
                        .build()).collect(Collectors.toList());
    }

    @Override
    public void deleteBook(int id) {
        findBookById(id);
        bookRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void softDelete(int id) {
        Book book = bookResponseToBooK(findBookById(id));
        book.setDeleted(LocalDateTime.now());
        bookRepository.save(book);
    }

    private Book createBook(BookRequest bookRequest){
        return Book.builder().name(bookRequest.getName())
                .price(bookRequest.getPrice())
                .build();
    }

    private BookResponse createBookResponse(Book book){
        return BookResponse.builder()
                .id(book.getId()).
                name(book.getName()).
                price(book.getPrice()).
                build();
    }
    private Book bookResponseToBooK(BookResponse bookResponse){
        return Book.builder().
                id(bookResponse.getId()).
                name(bookResponse.getName()).
                price(bookResponse.getPrice()).build();
    }

}
