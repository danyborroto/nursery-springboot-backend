package com.nursery.app.features.cart_product.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

public class CartProductRequestDTO {
    @NotNull(message = "El campo es obligatorio")
    @Positive(message = "El cart no puede ser negativo")
    private Integer cartId;
    @NotNull(message = "El producto es obligatorio")
    @Positive(message = "El producto no puede ser negativo")
    private Integer productId;
    @Positive(message = "El precio no puede ser menor de 1")
    private Double price;
    @Positive(message = "La cantidad no puede ser menor de 1")
    private Integer quantity;

    public CartProductRequestDTO(){}

    public CartProductRequestDTO(Integer cartId, Integer productId, Double price, Integer quantity) {
        this.cartId = cartId;
        this.productId = productId;
        this.price = price;
        this.quantity = quantity;
    }

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
