package com.ecommerce.ecommerce_backend.service.interf;

import com.ecommerce.ecommerce_backend.dto.CategoryDto;
import com.ecommerce.ecommerce_backend.dto.Response;

public interface CategoryService {

    Response createCategory(CategoryDto categoryRequest);

    Response updateCategory(Long categoryId, CategoryDto categoryRequest);

    Response getAllCategories();

    Response getCategoryById(Long categoryId);

    Response deleteCategory(Long categoryId);
}
