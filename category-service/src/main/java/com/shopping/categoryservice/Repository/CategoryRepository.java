package com.shopping.categoryservice.Repository;



import com.shopping.categoryservice.Model.Category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    public boolean existsByName(String name);

}