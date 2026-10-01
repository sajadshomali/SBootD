package org.example.springbootdenis.service.shoppingcard;

import org.example.springbootdenis.dto.request.ShoppingCardRequest;
import org.example.springbootdenis.dto.response.ShoppingCardResponse;
import org.example.springbootdenis.exceptions.MyExceptionRules;
import org.example.springbootdenis.model.*;
import org.example.springbootdenis.repository.BookRepository;
import org.example.springbootdenis.repository.FactorRepository;
import org.example.springbootdenis.repository.ShoppingCardRepository;
import org.example.springbootdenis.repository.UserRepository;
import org.example.springbootdenis.service.user.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ShoppingCardServiceImpl implements ShoppingCardService {
    private final ShoppingCardRepository shoppingCardRepository;
    private final FactorRepository factorRepository;
    private final UserRepository userRepository;
    private final BookRepository bookRepository;

    public ShoppingCardServiceImpl(ShoppingCardRepository shoppingCardRepository, FactorRepository factorRepository, UserRepository userRepository, BookRepository bookRepository) {
        this.shoppingCardRepository = shoppingCardRepository;
        this.factorRepository = factorRepository;
        this.userRepository = userRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public ShoppingCardResponse addShoppingCard(ShoppingCardRequest shoppingCardRequest) {
        User user = userRepository.findById(shoppingCardRequest.getUserId()).
                orElseThrow(() -> new MyExceptionRules("user.not.exist"));
        Book book = bookRepository.findById(shoppingCardRequest.getBookId()).
                orElseThrow(() -> new MyExceptionRules("book.not.exist"));
        Optional<Factor> byId = factorRepository.findByUserAndPayed(user, PAYED.UNPAYED);
        Factor factor = byId.orElseGet(() -> createFactor(user));
        factorRepository.save(factor);
        ShoppingCard shoppingCard = createShoppingCard(shoppingCardRequest, book, user, factor);
        return createShoppingCardResponse(shoppingCardRepository.save(shoppingCard));
    }

    private ShoppingCard createShoppingCard(ShoppingCardRequest shoppingCardRequest, Book book, User user, Factor factor) {
        return ShoppingCard.builder().
                factor(factor).
                book(book).
                count(shoppingCardRequest.getBookCount()).
                build();
    }

    private Factor createFactor(User user) {
        return Factor.builder().
                user(user).
                payed(PAYED.UNPAYED).build();
    }

    private ShoppingCardResponse createShoppingCardResponse(ShoppingCard shoppingCard) {
        return ShoppingCardResponse.builder().factorId(shoppingCard.getFactor().getId())
                .shoppingCardId(shoppingCard.getId()).build();
    }
}
