package com.shopping.cartservice.Repository;

import java.util.List;
import com.shopping.cartservice.Model.Item;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

    public List<Item> findByProductUpc(long upc);

    public void deleteByProductUpc(long upc);

}