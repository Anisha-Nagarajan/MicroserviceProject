package com.shopping.cartservice.Service;

import java.util.List;

import com.shopping.cartservice.Model.Item;
import com.shopping.cartservice.Model.Product;


public interface ItemService {

    public void save(Item item);

    public List<Item> findByProductUpc(long upc);

    public void updateProduct(Product product);

    public void deleteProduct(long upc);

}
