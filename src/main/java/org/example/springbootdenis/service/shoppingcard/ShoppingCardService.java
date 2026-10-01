package org.example.springbootdenis.service.shoppingcard;

import org.example.springbootdenis.dto.request.ShoppingCardRequest;
import org.example.springbootdenis.dto.response.ShoppingCardResponse;

public interface ShoppingCardService {
    ShoppingCardResponse addShoppingCard(ShoppingCardRequest shoppingCardRequest);
}
