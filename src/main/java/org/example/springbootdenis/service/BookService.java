package org.example.springbootdenis.service;

import org.example.springbootdenis.dto.request.BookRequest;
import org.example.springbootdenis.dto.response.BookResponse;
import org.jspecify.annotations.Nullable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BookService {
    BookResponse save(BookRequest bookRequest);

    Page<BookResponse> showAll(Pageable pageable);

    BookResponse findBookById(int id);

    List<BookResponse> findAllBooks(String name);

    void deleteBook(int id);
}
