package org.example.springbootdenis.service;

import org.example.springbootdenis.dto.request.BookRequest;
import org.example.springbootdenis.dto.response.BookResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BookService {
    public BookResponse save(BookRequest bookRequest);

    public Page<BookResponse> showAll(Pageable pageable);

    public BookResponse findBookById(int id);
}
