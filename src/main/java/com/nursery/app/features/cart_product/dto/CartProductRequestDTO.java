package com.nursery.app.features.cart_product.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

public class CartProductRequestDTO {
    @Positive(message = "La cantidad no puede ser menor de 1")
    private Integer quantity;

    public CartProductRequestDTO(){}

    public CartProductRequestDTO(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
