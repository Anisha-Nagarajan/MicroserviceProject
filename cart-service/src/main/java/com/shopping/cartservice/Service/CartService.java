package com.shopping.cartservice.Service;

import java.util.Optional;

import com.shopping.cartservice.Model.Cart;
import com.shopping.cartservice.Model.Product;


public interface CartService {

    public Cart save(Cart cart);

    public void deleteById(long cartId);

    public Optional<Cart> findById(long cartId);

    public Cart addItem(long upc, int quantity, Cart cart);

    public Cart updateCart(long upc, int quantity, Cart cart);

    public Cart deleteItem(long upc, Cart cart);

    public Cart updateTotal(Cart cart);

    public Cart updateSubTotal(int quantity, Product product);

    public boolean isCart(long cartId);

}