package org.example.springbootdenis.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ShoppingCardRequest {
    private int userId;
    private int bookId;
    private int bookCount;

}
