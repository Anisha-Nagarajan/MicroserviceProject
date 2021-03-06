package com.shopping.categoryservice.Service;


import java.util.Optional;

import com.shopping.categoryservice.Client.CartClient;
import com.shopping.categoryservice.Client.ImageClient;
import com.shopping.categoryservice.Model.Product;
import com.shopping.categoryservice.Repository.ProductRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ImageClient imageClient;
    private final CartClient cartClient;

    public ProductServiceImpl(ProductRepository productRepository, ImageClient imageClient,
            CartClient cartClient) {
        this.productRepository = productRepository;
        this.imageClient = imageClient;
        this.cartClient = cartClient;
    }

    @Override
    @Transactional
    public Product save(Product product) {
        cartClient.putItem(product);
        return productRepository.save(product);
    }

    @Override
    @Transactional
    public void deleteById(long upc) {
        imageClient.deleteImagesUpc(upc);
        cartClient.deleteItem(upc);
        productRepository.deleteById(upc);
    }

    @Override
    public Optional<Product> findById(long upc) {
        return productRepository.findById(upc);
    }

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public boolean isProduct(long upc) {
        return productRepository.existsById(upc);
    }

}
