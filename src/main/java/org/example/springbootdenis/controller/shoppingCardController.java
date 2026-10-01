package org.example.springbootdenis.controller;

import org.example.springbootdenis.dto.request.ShoppingCardRequest;
import org.example.springbootdenis.service.shoppingcard.ShoppingCardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shoppingCard")
public class shoppingCardController {
   private final ShoppingCardService shoppingCardService;

    public shoppingCardController(ShoppingCardService shoppingCardService) {
        this.shoppingCardService = shoppingCardService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addBook(@RequestBody ShoppingCardRequest shoppingCardRequest){
    return ResponseEntity.ok(shoppingCardService.addShoppingCard(shoppingCardRequest));
    }
}
