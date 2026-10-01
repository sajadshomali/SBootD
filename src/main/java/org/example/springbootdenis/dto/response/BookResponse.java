package org.example.springbootdenis.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class BookResponse {
    private int id;
    private String name;
    private long price;
}
