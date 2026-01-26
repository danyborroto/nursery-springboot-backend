package com.nursery.app.features.cart.dto;

import com.nursery.app.features.cart_product.dto.CartProductResponseDTO;

import java.util.List;

public class CartResponseDTO {
    private Integer cartId;
    private Integer userId;
    private Boolean active;
    private List<CartProductResponseDTO> products;

    public CartResponseDTO() {}

    public CartResponseDTO(Integer cartId, Integer userId, Boolean active, List<CartProductResponseDTO> products) {
        this.cartId = cartId;
        this.userId = userId;
        this.active = active;
        this.products = products;
    }

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public Boolean getActive() {
        return active;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public List<CartProductResponseDTO> getProducts() {
        return products;
    }

    public void setProducts(List<CartProductResponseDTO> products) {
        this.products = products;
    }
}
