package com.ecommerce.ecommerce_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.ecommerce_backend.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
