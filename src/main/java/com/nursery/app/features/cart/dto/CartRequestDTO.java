package com.nursery.app.features.cart.dto;

import jakarta.validation.constraints.Positive;

public class CartRequestDTO {
    @Positive(message = "El valor no puede ser negativo")
    private Integer cartId;
    private Integer userId;
    private Boolean active = true;

    public CartRequestDTO() {
    }

    public CartRequestDTO(Integer cartId, Integer userId, Boolean active) {
        this.cartId = cartId;
        this.userId = userId;
        this.active = active;
    }

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
