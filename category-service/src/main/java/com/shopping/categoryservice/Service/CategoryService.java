package com.shopping.categoryservice.Service;




import java.util.Optional;

import com.shopping.categoryservice.Model.Category;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface CategoryService {

    public Category save(Category category);

    public void deleteById(long categoryId);

    public Optional<Category> findById(long categoryId);

    public Page<Category> findAll(Pageable pageable);

    public boolean isCategory(String name);

}