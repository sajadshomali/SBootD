package org.example.springbootdenis.repository;


import org.example.springbootdenis.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {
    Optional<Book> findByName(String name);
   // @Query("select b from Book b where b.name like '%' +:name+ '%'")
    @Query("select b from Book b where b.name like '%' ||:name || '%' ")
   // @Query(nativeQuery = true ,value = "select * from Book")
    List<Book> findAllBooks(String name);

}
