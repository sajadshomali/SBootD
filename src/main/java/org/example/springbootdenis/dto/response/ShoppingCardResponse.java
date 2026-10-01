package org.example.springbootdenis.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder

public class ShoppingCardResponse {
    private final int shoppingCardId;
    private final int factorId;

}
