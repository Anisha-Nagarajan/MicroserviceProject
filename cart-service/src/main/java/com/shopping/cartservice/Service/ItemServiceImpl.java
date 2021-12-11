package com.shopping.cartservice.Service;


import java.math.BigDecimal;
import java.util.List;

import com.shopping.cartservice.Model.Cart;
import com.shopping.cartservice.Model.Item;
import com.shopping.cartservice.Model.Product;
import com.shopping.cartservice.Repository.ItemRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;

    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public void save(Item item) {
        itemRepository.save(item);
    }

    @Override
    public List<Item> findByProductUpc(long upc) {
        return itemRepository.findByProductUpc(upc);
    }

    @Override
    @Transactional
    public void updateProduct(Product product) {
        List<Item> items = findByProductUpc(product.getUpc());
        items.forEach(i -> {
            i.setProduct(product);
            i.setSubTotal(BigDecimal.valueOf(i.getQuantity()).multiply(product.getUnitPrice()));
            i.getCart().setTotalPrice(
                    i.getCart().getItems().stream().map(Item::getSubTotal).reduce(BigDecimal.ZERO, BigDecimal::add));
            save(i);
        });
    }

    @Override
    @Transactional
    public void deleteProduct(long upc) {
        List<Item> items = findByProductUpc(upc);
        items.forEach(i -> {
            Cart cart = i.getCart();
            cart.removeItem(i);
            cart.setTotalPrice(
                    cart.getItems().stream().map(Item::getSubTotal).reduce(BigDecimal.ZERO, BigDecimal::add));
        });
    }

}
