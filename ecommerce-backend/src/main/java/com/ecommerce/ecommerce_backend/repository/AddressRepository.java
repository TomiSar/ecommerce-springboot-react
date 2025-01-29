package com.ecommerce.ecommerce_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.ecommerce_backend.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
