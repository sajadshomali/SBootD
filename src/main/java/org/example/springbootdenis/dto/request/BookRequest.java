package org.example.springbootdenis.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookRequest {
   @NotBlank(message = "{empty.bookName.input}")
    private String name;
    @NotNull(message = "{null.book.price.input}")
    @Min(value = 5)
    private Long price;
}
