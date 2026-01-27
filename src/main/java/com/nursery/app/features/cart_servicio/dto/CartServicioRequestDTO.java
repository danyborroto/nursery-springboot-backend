package com.nursery.app.features.cart_servicio.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class CartServicioRequestDTO {
    @Positive(message = "El precio tiene que ser positivo")
    private Double price;

    public CartServicioRequestDTO() {}

    public CartServicioRequestDTO(Double price) {
        this.price = price;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
