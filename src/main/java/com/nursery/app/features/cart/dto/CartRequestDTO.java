package com.nursery.app.features.cart.dto;

import jakarta.validation.constraints.Positive;

public class CartRequestDTO {
    @Positive(message = "El valor no puede ser negativo")
    private Integer cartId;
    private Boolean active = true;

    public CartRequestDTO() {
    }

    public CartRequestDTO(Integer cartId, Boolean active) {
        this.cartId = cartId;
        this.active = active;
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

    public void setActive(Boolean active) {
        this.active = active;
    }
}
