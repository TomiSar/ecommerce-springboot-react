package com.ecommerce.ecommerce_backend.mapper;

import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.ecommerce.ecommerce_backend.dto.*;
import com.ecommerce.ecommerce_backend.entity.*;

@Component
public class EntityDtoMapper {

    // Address to DTO Basic
    public AddressDto mapAddressToDtoBasic(Address address) {
        AddressDto addressDto = new AddressDto();
        addressDto.setId(address.getId());
        addressDto.setStreet(address.getStreet());
        addressDto.setCity(address.getCity());
        addressDto.setState(address.getState());
        addressDto.setZipCode(address.getZipCode());
        addressDto.setCountry(address.getCountry());
        return addressDto;
    }

    // Category to DTO Basic
    public CategoryDto mapCategoryToDtoBasic(Category category){
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setId(category.getId());
        categoryDto.setName(category.getName());
        return categoryDto;
    }

    // OrderItem to DTO Basic
    public OrderItemDto mapOrderItemToDtoBasic(OrderItem orderItem) {
        OrderItemDto orderItemDto = new OrderItemDto();
        orderItemDto.setId(orderItem.getId());
        orderItemDto.setQuantity(orderItem.getQuantity());
        orderItemDto.setPrice(orderItem.getPrice());
        orderItemDto.setStatus(orderItem.getStatus().name());
        orderItemDto.setCreatedAt(orderItem.getCreatedAt());
        return orderItemDto;
    }

    // Product to DTO Basic
    public ProductDto mapProductToDtoBasic(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setName(product.getName());
        productDto.setDescription(product.getDescription());
        productDto.setPrice(product.getPrice());
        productDto.setImageUrl(product.getImageUrl());
        return productDto;
    }

    // Category to DTO Basic
    public UserDto mapUserToDtoBasic(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setEmail(user.getEmail());
        userDto.setName(user.getName());
        userDto.setPhoneNumber(user.getPhoneNumber());
        userDto.setPassword(user.getPassword());
        userDto.setRole(user.getRole().name());
        return userDto;
     }

    // OrderItem to DTO plus product
    public OrderItemDto mapOrderItemToDtoWithProduct(OrderItem orderItem) {
        System.out.println("mapOrderItemToDtoWithProduct is called");
        OrderItemDto orderItemDto = mapOrderItemToDtoBasic(orderItem);

        if (orderItem.getProduct() != null) {
            ProductDto productDto = mapProductToDtoBasic(orderItem.getProduct());
            orderItemDto.setProduct(productDto);
        }
        return orderItemDto;
    }

 
    // OrderItem to DTO plus Product an User
    public OrderItemDto mapOrderItemToDtoWithProductAndUser(OrderItem orderItem) {
        System.out.println("mapOrderItemToDtoWithProductAndUser is called");
        OrderItemDto orderItemDto = mapOrderItemToDtoWithProduct(orderItem);

        if (orderItem.getUser() != null){
            UserDto userDto = mapUserToDtoWithAddress(orderItem.getUser());
            orderItemDto.setUser(userDto);
        }
        return orderItemDto;
    }
    
    // User to DTO with Address
    public UserDto mapUserToDtoWithAddress(User user) {
        System.out.println("mapUserToDtoWithAddress is called");
        UserDto userDto = mapUserToDtoBasic(user);

        if (user.getAddress() != null){
            AddressDto addressDto = mapAddressToDtoBasic(user.getAddress());
            userDto.setAddress(addressDto);

        }
        return userDto;
    }

    // User to DTO with Address and Order Items History
    public UserDto mapUserToDtoWithAddressAndOrderHistory(User user) {
        System.out.println("mapUserToDtoWithAddressAndOrderHistory is called");
        UserDto userDto = mapUserToDtoWithAddress(user);

        if (user.getOrderItemList() != null && !user.getOrderItemList().isEmpty()) {
            userDto.setOrderItemList(user.getOrderItemList()
                    .stream()
                    .map(this::mapOrderItemToDtoWithProduct)
                    .collect(Collectors.toList()));
        }
        return userDto;
    }
}
