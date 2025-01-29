package com.ecommerce.ecommerce_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.ecommerce_backend.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
