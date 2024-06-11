package com.ohgiraffers.mapping.section03.compositekey.subsection02.idclass;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class CartRegistService {

    private CartRepository cartRepository;

    public CartRegistService(CartRepository cartRepository){
        this.cartRepository = cartRepository;
    }

    @Transactional
    public void addItemToCart(CartDTO cartDTO) {

        // 넘겨준 값들을 하나씩 바인딩
        Cart cart = new Cart(
                cartDTO.getCartOwnerMemberNo(),
                cartDTO.getAddedBookNo(),
                cartDTO.getQuantity()
        );

        // 바인딩한 값들을 저장해줌
        cartRepository.save(cart);
    }
}
